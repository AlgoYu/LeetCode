package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/6 5:16 下午
 * @Email 794763733@qq.com
 */
public class 第k个数 {
    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        int[] dp = new int[k];
        dp[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 1; i < k; i++) {
            int n1 = dp[p1] * 3;
            int n2 = dp[p2] * 5;
            int n3 = dp[p3] * 7;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if (dp[i] == n1) {
                p1++;
            }
            if (dp[i] == n2) {
                p2++;
            }
            if (dp[i] == n3) {
                p3++;
            }
        }
        return dp[k - 1];
    }
}
