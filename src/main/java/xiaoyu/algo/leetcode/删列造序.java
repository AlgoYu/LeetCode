package xiaoyu.algo.leetcode;

public class 删列造序 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int col = 0;
        for (int j = 0; j < m; j++) {
            int pre = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int ch = strs[i].charAt(j) - 'a';
                if (ch < pre) {
                    col++;
                    break;
                }
                pre = ch;
            }
        }
        return col;
    }
}
