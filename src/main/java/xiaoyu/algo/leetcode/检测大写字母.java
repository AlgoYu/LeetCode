package xiaoyu.algo.leetcode;

public class 检测大写字母 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        int lower = 0;
        int upper = 0;
        for (int i = 0; i < n; i++) {
            if (isLower(word.charAt(i))) {
                lower++;
            } else {
                upper++;
            }
        }
        return lower == n || upper == n || (upper == 1 && !isLower(word.charAt(0)));
    }

    private boolean isLower(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
