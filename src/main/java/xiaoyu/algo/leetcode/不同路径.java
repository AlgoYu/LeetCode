package xiaoyu.algo.leetcode;

public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        int next = 0, last = 0;
        for (int i = 0; i < m; i++) {
            last = next;
            next = 1 - next;
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[next][j] = 1;
                    continue;
                }
                dp[next][j] = dp[last][j] + dp[next][j - 1];
            }
        }
        return dp[next][n - 1];
    }
}
