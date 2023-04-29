package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/24 11:56 上午
 * @Email 794763733@qq.com
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        if (left >= 0) {
            int right = nums.length - 1;
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }
            swap(nums, left, right);
        }
        reverse(nums, left + 1, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
