package xiaoyu.algo.leetcode;

public class x的平方根 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int l = 0, r = x;
        int ans = 0;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long) mid * (long) mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
