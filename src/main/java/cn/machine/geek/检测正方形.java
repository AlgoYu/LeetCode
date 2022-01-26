package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 检测正方形 {
    Map<Integer, Map<Integer, Integer>> pointMap;

    public 检测正方形() {
        pointMap = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        pointMap.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> map = pointMap.get(y);
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        // 在同一个y轴上
        Map<Integer, Integer> map = pointMap.get(y);
        // y轴上一个都没有就不可能有正方形
        if (map == null) {
            return 0;
        }
        int count = 0;
        // 遍历所有y点
        for (Map.Entry<Integer, Map<Integer, Integer>> xPoint : pointMap.entrySet()) {
            Integer key = xPoint.getKey();
            // 略过自己
            if (key == y) {
                continue;
            }
            Map<Integer, Integer> value = xPoint.getValue();
            // 两个y之间的距离
            int d = key - y;
            count += value.getOrDefault(x, 0) * map.getOrDefault(x + d, 0) * value.getOrDefault(x + d, 0);
            count += value.getOrDefault(x, 0) * map.getOrDefault(x - d, 0) * value.getOrDefault(x - d, 0);
        }
        return count;
    }
}
