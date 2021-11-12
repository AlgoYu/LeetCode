package cn.machine.geek;

public class 猜数字大小II {
    public int getMoneyAmount(int n) {
        // 题意是按二分查找来猜数字
        // [0]是更大 [1]是更小 [2]是猜中
        int[][] dp = new int[n + 1][n + 1];
        // 最小
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];
    }
}
