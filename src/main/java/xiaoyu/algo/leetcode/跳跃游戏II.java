package xiaoyu.algo.leetcode;

/**
 * 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class 跳跃游戏II {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = 1; i < size; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[size - 1];
    }
}
