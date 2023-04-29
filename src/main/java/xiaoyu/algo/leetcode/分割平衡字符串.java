package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/7 4:18 下午
 * @Email 794763733@qq.com
 */
public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                tmp++;
            } else {
                tmp--;
            }

            if (tmp == 0) {
                max++;
            }
        }
        return max;
    }
}
