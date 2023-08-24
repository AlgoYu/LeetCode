package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new LinkedList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int n, List<Integer> list) {
        if (n >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums, n, i);
            list.add(nums[n]);
            backtrack(nums, n + 1, list);
            list.remove(list.size() - 1);
            swap(nums, n, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
