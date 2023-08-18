package xiaoyu.algo.leetcode;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int index = 0;
        int max = 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i < 2 || dp[j + 1][j + i - 1]) {
                        dp[j][j + i] = true;
                        if (i + 1 > max) {
                            index = j;
                            max = i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(index, index + max);
    }
}
