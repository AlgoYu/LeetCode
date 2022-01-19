package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
                map.put(nums[i], i);
                continue;
            }
            if (Math.abs(i - index) <= k) {
                return true;
            } else if (index == 0) {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
