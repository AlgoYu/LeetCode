package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 最长数对链 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[pairs.length - 1];
    }
}
