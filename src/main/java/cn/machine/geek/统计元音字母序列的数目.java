package cn.machine.geek;

public class 统计元音字母序列的数目 {
    private static final int MOD = 1000000007;

    public int countVowelPermutation(int n) {
        long[][] dp = new long[2][5];
        int index = 0;
        // 初始化
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        // 计算
        for (int i = 1; i < n; i++) {
            int pre = index;
            index ^= 1;
            // a前面可以是e,i,u
            dp[index][0] = (dp[pre][1] + dp[pre][2] + dp[pre][4]) % MOD;
            // e前面可以是a,i
            dp[index][1] = (dp[pre][0] + dp[pre][2]) % MOD;
            // i前面可以是e,o
            dp[index][2] = (dp[pre][1] + dp[pre][3]) % MOD;
            // o前面可以是i
            dp[index][3] = dp[pre][2];
            // u前面可以是i,o
            dp[index][4] = (dp[pre][2] + dp[pre][3]) % MOD;
        }
        long count = 0;
        for (int i = 0; i < 5; i++) {
            count = (count + dp[index][i]) % MOD;
        }
        return (int) count;
    }
}
