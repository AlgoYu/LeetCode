package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/2 1:23 下午
 * @Email 794763733@qq.com
 */
public class 数字转换为十六进制数 {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long number = num;
        StringBuilder sb = new StringBuilder();
        if (number < 0) {
            number = (1L << 32) - (-number);
        }
        while (number > 0) {
            sb.append(getChar(number % 16));
            number /= 16;
        }
        return sb.reverse().toString();
    }

    private String getChar(long num) {
        if (num < 10) {
            return num + "";
        }
        return (char) ('a' + (num - 10)) + "";
    }
}
