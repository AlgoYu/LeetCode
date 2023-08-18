package xiaoyu.algo.leetcode;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], pre = max;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
