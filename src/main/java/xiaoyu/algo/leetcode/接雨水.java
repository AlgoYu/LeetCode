package xiaoyu.algo.leetcode;

public class 接雨水 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        int lh = 0, rh = 0;
        while (l < r) {
            lh = Math.max(lh, height[l]);
            rh = Math.max(rh, height[r]);
            if (lh < rh) {
                ans += lh - height[l++];
            } else {
                ans += rh - height[r--];
            }
        }
        return ans;
    }
}
