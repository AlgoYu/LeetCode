package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 三角形类型 {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        return nums[0] == nums[1] || nums[1] == nums[2] ? "isosceles" : "scalene";
    }
}
