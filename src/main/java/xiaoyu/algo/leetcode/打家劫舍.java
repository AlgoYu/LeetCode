package xiaoyu.algo.leetcode;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i > 0) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            }
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
