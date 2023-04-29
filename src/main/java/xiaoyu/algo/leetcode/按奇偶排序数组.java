package xiaoyu.algo.leetcode;

public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 0) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 1) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
