package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 最少移动次数使数组元素相等II {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        int pivot = nums[n >> 1];
        for (int i = 0; i < n; i++) {
            result += Math.abs(nums[i] - pivot);
        }
        return result;
    }
}
