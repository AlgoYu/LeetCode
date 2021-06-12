package cn.machine.geek;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    /**
     * 解题思路：
     * 常见解法	时间复杂度	空间复杂度
     * 暴力搜索	O(N^2)O(N
     * 2
     *  )	O(1)O(1)
     * 分治思想	O(NlogN)O(NlogN)	O(logN)O(logN)
     * 动态规划	O(N)O(N)	O(1)O(1)
     * 动态规划是本题的最优解法，以下按照标准流程解题。
     *
     * 动态规划解析：
     * 状态定义： 设动态规划列表 dpdp ，dp[i]dp[i] 代表以元素 nums[i]nums[i] 为结尾的连续子数组最大和。
     *
     * 为何定义最大和 dp[i]dp[i] 中必须包含元素 nums[i]nums[i] ：保证 dp[i]dp[i] 递推到 dp[i+1]dp[i+1] 的正确性；如果不包含 nums[i]nums[i] ，递推时则不满足题目的 连续子数组 要求。
     * 转移方程： 若 dp[i-1] \leq 0dp[i−1]≤0 ，说明 dp[i - 1]dp[i−1] 对 dp[i]dp[i] 产生负贡献，即 dp[i-1] + nums[i]dp[i−1]+nums[i] 还不如 nums[i]nums[i] 本身大。
     *
     * 当 dp[i - 1] > 0dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]dp[i]=dp[i−1]+nums[i] ；
     * 当 dp[i - 1] \leq 0dp[i−1]≤0 时：执行 dp[i] = nums[i]dp[i]=nums[i] ；
     * 初始状态： dp[0] = nums[0]dp[0]=nums[0]，即以 nums[0]nums[0] 结尾的连续子数组最大和为 nums[0]nums[0] 。
     *
     * 返回值： 返回 dpdp 列表中的最大值，代表全局最大值。
     *
     *
     *
     * 空间复杂度降低：
     * 由于 dp[i]dp[i] 只与 dp[i-1]dp[i−1] 和 nums[i]nums[i] 有关系，因此可以将原数组 numsnums 用作 dpdp 列表，即直接在 numsnums 上修改即可。
     * 由于省去 dpdp 列表使用的额外空间，因此空间复杂度从 O(N)O(N) 降至 O(1)O(1) 。
     * 复杂度分析：
     *
     * 时间复杂度 O(N)O(N) ： 线性遍历数组 numsnums 即可获得结果，使用 O(N)O(N) 时间。
     * 空间复杂度 O(1)O(1) ： 使用常数大小的额外空间。
     *
     * 1 / 10
     *
     * 代码：
     * pythonjava
     *
     * class Solution {
     *     public int maxSubArray(int[] nums) {
     *         int res = nums[0];
     *         for(int i = 1; i < nums.length; i++) {
     *             nums[i] += Math.max(nums[i - 1], 0);
     *             res = Math.max(res, nums[i]);
     *         }
     *         return res;
     *     }
     * }
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
