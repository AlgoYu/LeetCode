package xiaoyu.algo.leetcode;

public class 统计星号 {
    public int countAsterisks(String s) {
        int count = 2;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                count++;
            }
            if ((count & 1) == 0 && c == '*') {
                result++;
            }
        }
        return result;
    }
}
