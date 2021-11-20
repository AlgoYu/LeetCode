package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 最长和谐子序列 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue() + map.getOrDefault(entry.getKey() + 1, -entry.getValue()));
            max = Math.max(max, entry.getValue() + map.getOrDefault(entry.getKey() - 1, -entry.getValue()));
        }
        return max;
    }
}
