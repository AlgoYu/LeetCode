package xiaoyu.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            if (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            if (left < right && (nums[left] & 1) == 0 && (nums[right] & 1) == 1) {
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