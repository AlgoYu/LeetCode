package xiaoyu.algo.leetcode;

public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }
}
