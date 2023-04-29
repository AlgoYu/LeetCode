package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/10 11:16 上午
 * @Email 794763733@qq.com
 */
public class 两数相除 {
    public int divide(int dividend, int divisor) { // 被除数 除数
        long dividendL = dividend;
        long divisorL = divisor;
        // 一个数正、一个数负数
        boolean flag = false;
        if (dividendL > 0 ^ divisorL > 0) {
            flag = true;
        }
        long result = 0;
        dividendL = Math.abs(dividendL);
        divisorL = Math.abs(divisorL);
        if (divisorL != 1) {
            while (dividendL >= divisorL) {
                dividendL -= divisorL;
                result++;
            }
        } else {
            result = dividendL;
        }
        if (flag) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
