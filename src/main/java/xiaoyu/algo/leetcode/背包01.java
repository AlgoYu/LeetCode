package xiaoyu.algo.leetcode;

/**
 * @Author: MachineGeek
 * @Description:
 * @Email: 794763733@qq.com
 * @Date: 2021/2/27
 */
public class 背包01 {
    public int maxValue(int[] values, int[] weights, int capacity) {
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i]);
            }
        }
        return dp[values.length][capacity];
    }
}
