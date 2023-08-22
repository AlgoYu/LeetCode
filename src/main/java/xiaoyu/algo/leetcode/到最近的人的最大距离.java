package xiaoyu.algo.leetcode;

public class 到最近的人的最大距离 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                int l = i - 1;
                int r = i + 1;
                while (l >= 0 && seats[l] == 0) {
                    l--;
                }
                while (r < n && seats[r] == 0) {
                    r++;
                }
                if (l >= 0 && r < n) {
                    max = Math.max((r - l) / 2, max);
                } else {
                    l = Math.max(0, l);
                    r = Math.min(seats.length - 1, r);
                    max = Math.max(max, r - l);
                }
            }
        }
        return max;
    }
}
