package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/23 6:13 下午
 * @Email 794763733@qq.com
 */
public class 括号的最大嵌套深度 {
    public int maxDepth(String s) {
        int max = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                n++;
                max = Math.max(n, max);
            } else if (ch == ')') {
                n--;
            }
        }
        return max;
    }
}
