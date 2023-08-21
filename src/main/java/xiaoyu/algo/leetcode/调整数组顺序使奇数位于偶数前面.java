package xiaoyu.algo.leetcode;

public class 调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
            }
            if ((nums[right] & 1) == 0) {
                right--;
            }
            if ((nums[left] & 1) == 1 && (nums[right] & 1) == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
