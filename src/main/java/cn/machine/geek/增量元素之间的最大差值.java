package cn.machine.geek;

public class 增量元素之间的最大差值 {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxDifference = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                maxDifference = Math.max(nums[i] - min, maxDifference);
            } else {
                min = nums[i];
            }
        }
        return maxDifference;
    }
}
