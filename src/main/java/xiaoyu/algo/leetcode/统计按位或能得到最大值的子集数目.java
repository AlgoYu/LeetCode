package xiaoyu.algo.leetcode;

public class 统计按位或能得到最大值的子集数目 {
    int max;
    int total;

    public int countMaxOrSubsets(int[] nums) {
        max = Integer.MIN_VALUE;
        backtracking(nums, 0, 0);
        return total;
    }

    private void backtracking(int[] nums, int index, int sum) {
        if (index >= nums.length) {
            if (sum == max) {
                total++;
            }
            if (sum > max) {
                total = 1;
                max = sum;
            }
            return;
        }
        backtracking(nums, index + 1, nums[index] | sum);
        backtracking(nums, index + 1, sum);
    }
}
