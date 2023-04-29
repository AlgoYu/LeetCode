package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length && k > 0) {
            if (nums[index] < 0) {
                nums[index] = -nums[index];
            } else {
                break;
            }
            index++;
            k--;
        }
        if (k > 0) {
            Arrays.sort(nums);
            nums[0] = (k & 1) != 0 ? -nums[0] : nums[0];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        return count;
    }
}
