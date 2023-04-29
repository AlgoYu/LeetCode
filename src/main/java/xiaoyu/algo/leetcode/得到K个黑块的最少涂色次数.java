package xiaoyu.algo.leetcode;

public class 得到K个黑块的最少涂色次数 {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int n = blocks.length();
        int w = 0;
        int min = Integer.MAX_VALUE;
        while (l < n) {
            if (blocks.charAt(l) == 'W') {
                w++;
            }
            if (l + 1 >= k) {
                min = Math.min(w, min);
            }
            if (l + 1 >= k && blocks.charAt(l + 1 - k) == 'W') {
                w--;
            }
            l++;
        }
        return min;
    }
}
