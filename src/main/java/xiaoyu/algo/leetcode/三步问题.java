package xiaoyu.algo.leetcode;

public class 三步问题 {
    private static final int M = 1000000007;

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int p3 = 1, p2 = 2, p1 = 4;
        int cur = 0;
        for (int i = 4; i <= n; i++) {
            cur = ((p1 + p2) % M + p3) % M;
            p3 = p2;
            p2 = p1;
            p1 = cur;
        }
        return cur;
    }
}