package xiaoyu.algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 完全平方数 {
    public int numSquares(int n) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i > n) {
                break;
            }
            nums.add(i * i);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < nums.size(); j++) {
                Integer num = nums.get(j);
                if (num <= i) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n] > n ? -1 : dp[n];
    }
}
