package xiaoyu.algo.leetcode;

public class 验证回文串 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                char temp = ch;
                if (temp >= 'A' && temp <= 'Z') {
                    temp = (char) ('a' + (temp - 'A'));
                }
                sb.append(temp);
            }
        }
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
