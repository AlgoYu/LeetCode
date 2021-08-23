package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/13 11:36 上午
 * @Email 794763733@qq.com
 */
public class 字符串相乘 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        // 先相乘
        for (int i = n - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                result[i + j + 1] += n1 * n2;
            }
        }
        // 向前补进位
        for (int i = n + m - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        // 转为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = result[0] == 0 ? 1 : 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
