package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 与对应负数同时存在的最大正整数 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(-nums[i])) {
                max = Math.max(Math.abs(nums[i]), max);
            }
            set.add(nums[i]);
        }
        return max;
    }
}
