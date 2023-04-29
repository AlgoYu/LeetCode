package xiaoyu.algo.leetcode;

public class 下载插件 {
    public int leastMinutes(int n) {
        // 设置一个动态规划数组
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 1);
        }
        return dp[n];
    }
}