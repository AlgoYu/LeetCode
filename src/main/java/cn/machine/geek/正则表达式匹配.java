package cn.machine.geek;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (match(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String a, String b, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (b.charAt(j - 1) == '.') {
            return true;
        }
        return a.charAt(i - 1) == b.charAt(j - 1);
    }

    /**
     * @Author XiaoYu
     * @Description TODO 这个方法不对
     * @Datetime 2021/8/7 8:16 下午
     * @Param [s, p, si, pi, mi, match]
     * @Return boolean
     **/
    private boolean isMatch(char[] s, char[] p, int si, int pi, int mi, boolean match) {
        if (si == s.length && (pi == p.length || '*' == p[p.length - 1])) {
            return true;
        }
        if (si == s.length || pi == p.length) {
            return false;
        }
        if (p[pi] == '.') {
            return isMatch(s, p, si + 1, pi + 1, si, true);
        }
        if (p[pi] == '*') {
            if (mi == -1 || !match) {
                return false;
            }
            if (s[si] != s[mi]) {
                return false;
            }
            return isMatch(s, p, si + 1, pi, mi, match);
        }
        if (s[si] != p[pi]) {
            return false;
        }
        return isMatch(s, p, si + 1, pi + 1, -1, false);
    }
}
