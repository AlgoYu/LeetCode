package cn.machine.geek;

public class 最大升序子数组和 {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int cur = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(cur, max);
        }
        max = Math.max(cur, max);
        return max;
    }
}
