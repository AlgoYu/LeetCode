package xiaoyu.algo.leetcode;

public class 按摩师 {
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp0 = 0, dp1 = nums[0];
        for (int i = 1; i < n; i++) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + nums[i];

            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
    }
}