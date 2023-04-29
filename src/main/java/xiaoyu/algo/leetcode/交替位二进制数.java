package xiaoyu.algo.leetcode;

public class 交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        int len = sb.length();
        for (int i = 1; i < len; i++) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
