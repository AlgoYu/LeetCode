package xiaoyu.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                int value = nums[i] + nums[l] + nums[r];
                if (value > 0) {
                    r--;
                } else if (value < 0) {
                    l++;
                } else {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                }
            }
        }
        return result;
    }
}