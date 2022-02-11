package cn.machine.geek;

import java.util.Arrays;

public class 学生分数的最小差值 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            min = Math.min(nums[i + k] - nums[i], min);
        }
        return min;
    }
}
