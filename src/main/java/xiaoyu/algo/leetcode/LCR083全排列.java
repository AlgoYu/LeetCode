package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCR083全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    public void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
