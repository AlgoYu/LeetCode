package xiaoyu.algo.leetcode;

public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int m = 0;
        for (int i = 0; i <= n; i++) {
            m ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            m ^= nums[i];
        }
        return m;
    }
}
