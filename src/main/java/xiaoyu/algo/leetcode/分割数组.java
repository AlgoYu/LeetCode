package xiaoyu.algo.leetcode;

public class 分割数组 {
    public int partitionDisjoint(int[] nums) {
        int curMax = nums[0];
        int leftMax = curMax;
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            leftMax = Math.max(leftMax, nums[i - 1]);
            if (nums[i] < curMax) {
                size = i + 1;
                curMax = leftMax;
            }
        }
        return size;
    }
}