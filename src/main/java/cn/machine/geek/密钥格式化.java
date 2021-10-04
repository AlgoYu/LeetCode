package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/4 1:58 下午
 * @Email 794763733@qq.com
 */
public class 密钥格式化 {
    public static void main(String[] args) {
        licenseKeyFormatting("a-a-a-a-", 1);
    }

    public static String licenseKeyFormatting(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (k <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '-') {
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('A' + ch - 'a');
            }
            sb.append(ch);
            total++;
            if (total % k == 0) {
                sb.append('-');
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.reverse().toString();
    }
}
