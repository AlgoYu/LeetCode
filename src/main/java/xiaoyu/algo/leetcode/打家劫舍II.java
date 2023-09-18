package xiaoyu.algo.leetcode;

public class 打家劫舍II {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < nums.length; i++) {
            dp1[i] = nums[i];
            dp2[i] = nums[i];
        }
        return Math.max(solution(nums, dp1, 0, n - 1), solution(nums, dp2, 1, n));
    }

    public int solution(int[] nums, int[] dp, int start, int end) {
        for (int i = start; i < end; i++) {
            if (i >= start + 1) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            if (i >= start + 2) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[end - 1];
    }
}
