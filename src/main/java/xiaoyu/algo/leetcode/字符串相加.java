package xiaoyu.algo.leetcode;

public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        while (i1 >= 0 || i2 >= 0 || pre != 0) {
            int v1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int v2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            int v = v1 + v2 + pre;
            sb.append(v % 10);
            pre = v / 10;
            i1--;
            i2--;
        }
        return sb.reverse().toString();
    }
}
