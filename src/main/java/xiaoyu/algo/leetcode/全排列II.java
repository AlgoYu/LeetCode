package xiaoyu.algo.leetcode;

import java.util.*;

public class 全排列II {
    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new LinkedList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int n, List<Integer> list) {
        if (n >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, n + 1, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
