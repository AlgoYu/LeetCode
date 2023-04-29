package xiaoyu.algo.leetcode;

public class 转换字符串的最少操作次数 {
    public int minimumMoves(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                cnt++;
                i += 2;
            }
        }
        return cnt;
    }
}
