package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 7:07 下午
 * @Email 794763733@qq.com
 */
public class 找出所有子集的异或总和再求和 {
    int count;

    public int subsetXORSum(int[] nums) {
        count = 0;
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int pre) {
        if (index == nums.length) {
            count += pre;
            return;
        }
        // 从这里开始
        dfs(nums, index + 1, pre);
        // 连续
        dfs(nums, index + 1, nums[index] ^ pre);
    }
}
