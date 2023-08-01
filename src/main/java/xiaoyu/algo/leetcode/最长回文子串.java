package xiaoyu.algo.leetcode;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int max = 0;
        String maxStr = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < n; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (s.charAt(l) == s.charAt(r) && (r - l < 3 || (dp[l + 1][r - 1]))) {
                    dp[l][r] = true;
                    if (r - l > max) {
                        max = r - l;
                        maxStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return maxStr;
    }
}
