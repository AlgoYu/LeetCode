package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(nums, index + 1, result, list);
        list.remove(list.size() - 1);
        backtrack(nums, index + 1, result, list);
    }
}
