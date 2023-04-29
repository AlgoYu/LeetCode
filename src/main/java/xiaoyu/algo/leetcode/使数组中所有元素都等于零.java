package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 使数组中所有元素都等于零 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int index = 0, count = 0, total = 0;
        while (index < nums.length) {
            if (nums[index] - total > 0) {
                count++;
                total = total + nums[index] - total;
                if (total == nums[nums.length - 1]) {
                    break;
                }
            }
            index++;
        }
        return count;
    }
}
