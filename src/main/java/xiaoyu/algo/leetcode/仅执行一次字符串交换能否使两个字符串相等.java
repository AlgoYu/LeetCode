package xiaoyu.algo.leetcode;

public class 仅执行一次字符串交换能否使两个字符串相等 {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int one = -1, two = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (one == -1) {
                    one = i;
                    continue;
                }
                if (two == -1) {
                    two = i;
                    continue;
                }
                return false;
            }
        }
        if (one == -1) {
            return true;
        }
        if (two == -1) {
            return false;
        }
        return s1.charAt(one) == s2.charAt(two) && s1.charAt(two) == s2.charAt(one);
    }
}
