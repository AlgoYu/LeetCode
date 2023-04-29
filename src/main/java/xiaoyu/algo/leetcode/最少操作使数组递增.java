package xiaoyu.algo.leetcode;

public class 最少操作使数组递增 {
    public int minOperations(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int value = (nums[i - 1] + 1) - nums[i];
                nums[i] = nums[i] + value;
                result = result + value;
            }
        }
        return result;
    }
}