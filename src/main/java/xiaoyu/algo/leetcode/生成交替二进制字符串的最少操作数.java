package xiaoyu.algo.leetcode;

public class 生成交替二进制字符串的最少操作数 {
    public int minOperations(String s) {
        int totalA = 0;
        int totalB = 0;
        char[] chars = s.toCharArray();
        char a = '0';
        char b = '1';
        char tmp;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != a) {
                totalA++;
            }
            if (chars[i] != b) {
                totalB++;
            }
            tmp = a;
            a = b;
            b = tmp;
        }
        return Math.min(totalA, totalB);
    }
}