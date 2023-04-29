package xiaoyu.algo.leetcode;

public class 粉刷房子 {
    public int minCost(int[][] costs) {
        // 初始状态
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        // 状态压缩，轮转状态下标0和1
        int index = 0;
        for (int i = 1; i < costs.length; i++) {
            int next = (index + 1) % 2;
            // 遍历颜色
            for (int j = 0; j < 3; j++) {
                // 加上之前的颜色
                dp[next][j] = Math.min(dp[index][(j + 1) % 3], dp[index][(j + 2) % 3]) + costs[i][j];
            }
            index = next;
        }
        // 3选1
        return Math.min(Math.min(dp[index][0], dp[index][1]), dp[index][2]);
    }
}
