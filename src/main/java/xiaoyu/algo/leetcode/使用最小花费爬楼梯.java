package xiaoyu.algo.leetcode;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 */
public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
    /**
     * 方法一：动态规划
     * 假设数组 \textit{cost}cost 的长度为 nn，则 nn 个阶梯分别对应下标 00 到 n-1n−1，楼层顶部对应下标 nn，问题等价于计算达到下标 nn 的最小花费。可以通过动态规划求解。
     *
     * 创建长度为 n+1n+1 的数组 \textit{dp}dp，其中 \textit{dp}[i]dp[i] 表示达到下标 ii 的最小花费。
     *
     * 由于可以选择下标 00 或 11 作为初始阶梯，因此有 \textit{dp}[0]=\textit{dp}[1]=0dp[0]=dp[1]=0。
     *
     * 当 2 \le i \le n2≤i≤n 时，可以从下标 i-1i−1 使用 \textit{cost}[i-1]cost[i−1] 的花费达到下标 ii，或者从下标 i-2i−2 使用 \textit{cost}[i-2]cost[i−2] 的花费达到下标 ii。为了使总花费最小，\textit{dp}[i]dp[i] 应取上述两项的最小值，因此状态转移方程如下：
     *
     * \textit{dp}[i]=\min(\textit{dp}[i-1]+\textit{cost}[i-1],\textit{dp}[i-2]+\textit{cost}[i-2])
     * dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
     *
     * 依次计算 \textit{dp}dp 中的每一项的值，最终得到的 \textit{dp}[n]dp[n] 即为达到楼层顶部的最小花费。
     *
     * JavaJavaScriptC++GolangPython3C
     *
     * class Solution {
     *     public int minCostClimbingStairs(int[] cost) {
     *         int n = cost.length;
     *         int[] dp = new int[n + 1];
     *         dp[0] = dp[1] = 0;
     *         for (int i = 2; i <= n; i++) {
     *             dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
     *         }
     *         return dp[n];
     *     }
     * }
     * 上述代码的时间复杂度和空间复杂度都是 O(n)O(n)。注意到当 i \ge 2i≥2 时，\textit{dp}[i]dp[i] 只和 \textit{dp}[i-1]dp[i−1] 与 \textit{dp}[i-2]dp[i−2] 有关，因此可以使用滚动数组的思想，将空间复杂度优化到 O(1)O(1)。
     *
     * JavaJavaScriptC++GolangPython3C
     *
     * class Solution {
     *     public int minCostClimbingStairs(int[] cost) {
     *         int n = cost.length;
     *         int prev = 0, curr = 0;
     *         for (int i = 2; i <= n; i++) {
     *             int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
     *             prev = curr;
     *             curr = next;
     *         }
     *         return curr;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{cost}cost 的长度。需要依次计算每个 \textit{dp}dp 值，每个值的计算需要常数时间，因此总时间复杂度是 O(n)O(n)。
     *
     * 空间复杂度：O(1)O(1)。使用滚动数组的思想，只需要使用有限的额外空间。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-l-ncf8/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
