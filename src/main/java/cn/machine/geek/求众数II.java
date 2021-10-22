package cn.machine.geek;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/22 11:35 上午
 * @Email 794763733@qq.com
 */
public class 求众数II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int n = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            Integer count = map.getOrDefault(num, 0) + 1;
            if (count > n && !result.contains(num)) {
                result.add(num);
            }
            map.put(num, count);
        }
        return result;
    }
}
