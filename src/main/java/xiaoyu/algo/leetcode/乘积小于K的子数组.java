package xiaoyu.algo.leetcode;

public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = 0;
        int left = 0, right = 0;
        int answer = 1;
        while (right < nums.length) {
            answer *= nums[right];
            while (answer >= k && left <= right) {
                answer /= nums[left];
                left++;
            }
            n += right - left + 1;
            right++;
        }
        return n;
    }
}
