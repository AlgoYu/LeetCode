package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/10 11:16 上午
 * @Email 794763733@qq.com
 */
public class 两数相除 {
    public int divide(int dividend, int divisor) { // 被除数 除数
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[2^31, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        //System.out.println(a + " " + b);
        if (a > b) return 0;
        int ans = div(a, b);
        return sign == -1 ? -ans : ans;
    }

    private static int div(int a, int b) {
        if (a > b) return 0;
        int count = 1;
        int tb = b;
        while (tb + tb >= a && tb + tb < 0) { // 溢出之后不再小于0
            tb += tb;
            count += count;
            //System.out.println(tb + " " + count + " " + count*b);
        }
        return count + div(a - tb, b);
    }
}
