package cn.machine.geek;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/9 4:43 下午
 * @Email 794763733@qq.com
 */
public class 将数据流变为多个不相交区间 {
    Set<Integer> set;
    TreeMap<Integer, Integer> treeMap;

    public 将数据流变为多个不相交区间() {
        treeMap = new TreeMap<>();
        set = new HashSet<>();
    }

    public void addNum(int val) {
        // 重复无效
        if (set.contains(val)) {
            return;
        }
        // 加入去重
        set.add(val);
        // 遍历Map
        Map.Entry<Integer, Integer> end = null;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            // 在某个区间范围内直接退出
            if (val >= entry.getKey() && val <= entry.getValue()) {
                return;
            }
            // 在一个区间的结束区间+1，此时不可能会存在于任何区间范围内，以为存在的都已经合并。
            if (entry.getValue() == val - 1) {
                end = entry;
                break;
            }
        }
        // 存在一个结束区间正好比val小1的
        boolean existsEnd = end != null;
        // 存在一个起始区间正好比val大1的
        boolean existsStart = treeMap.containsKey(val + 1);
        // 都存在，合并区间
        if (existsStart && existsEnd) {
            // 更新区间
            treeMap.put(end.getKey(), treeMap.get(val + 1));
            // 删除val + 1区间
            treeMap.remove(val + 1);
            return;
        }
        // 存在起始区间比val大1的
        if (existsStart) {
            treeMap.put(val, treeMap.get(val + 1));
            treeMap.remove(val + 1);
            return;
        }
        // 存在结束区间比val小1的
        if (existsEnd) {
            end.setValue(val);
            return;
        }
        // 都没有，直接初始化区间
        treeMap.put(val, val);
    }

    public int[][] getIntervals() {
        int[][] result = new int[treeMap.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return result;
    }
}
