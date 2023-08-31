package xiaoyu.algo.leetcode;

public class 整数反转 {
    public int reverse(int x) {
        long result = 0;
        boolean nev = x < 0;
        x = Math.abs(x);
        while (x > 0) {
            int unit = x % 10;
            result = result * 10 + unit;
            x = x / 10;
        }
        if (nev) {
            result = -result;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }
}