package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/3 12:48 下午
 * @Email 794763733@qq.com
 */
public class 分数到小数 {
    public static void main(String[] args) {
        new 分数到小数().fractionToDecimal(-50, 8);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long ln = (long) numerator;
        long ld = (long) denominator;
        if (ln % ld == 0) {
            return String.valueOf(ln / ld);
        }
        StringBuilder sb = new StringBuilder();
        if (ln < 0 ^ ld < 0) {
            sb.append("-");
        }
        // 整数
        ln = Math.abs(ln);
        ld = Math.abs(ld);
        sb.append(ln / ld).append('.');
        // 小数
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder min = new StringBuilder();
        long n = ln % ld * 10L;
        int index = 0;
        while (n != 0 && !map.containsKey(n)) {
            map.put(n, index++);
            min.append(n / ld);
            n = n % ld * 10;
        }
        // 循环
        if (n != 0) {
            min.insert(map.get(n), "(");
            min.append(")");
        }
        sb.append(min);
        return sb.toString();
    }
}
