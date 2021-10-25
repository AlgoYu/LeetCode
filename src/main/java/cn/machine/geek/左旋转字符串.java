package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 6:45 下午
 * @Email 794763733@qq.com
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        if (s.length() <= 1 || n >= s.length()) {
            return s;
        }
        int i = n % s.length();
        return s.substring(i) + s.substring(0, i);
    }
}
