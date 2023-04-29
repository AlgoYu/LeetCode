package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/7 12:27 下午
 * @Email 794763733@qq.com
 */
public class 字符串中的单词数 {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || (i > 0 && s.charAt(i - 1) != ' ')) {
                continue;
            }
            count++;
        }
        return count;
    }
}
