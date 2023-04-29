package xiaoyu.algo.leetcode;

/**
 * LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,2,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,3,10]
 * <p>
 * 输出：8
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 */
public class 拿硬币 {
    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int min = 0;
        for (int i = 1; i < coins.length; i++) {
            min = Math.min(min + coins[i], min + coins[i] / 2);
        }
        return min;
    }
    /**
     * 有 n 堆硬币，每次从任意一堆拿走一枚或者两枚。问最少几次能够全部拿完。
     *
     * 题解
     * 题目中虽然给了 n 堆硬币，但是最终每一堆都是要拿完的。而每一堆拿的情况又不影响其他硬币堆，因此每一堆硬币的拿法实际上是互相独立的。
     *
     * 于是我们可以只考虑一堆的情况。假设一堆有 x 枚硬币，既然我们的目的是尽早拿完所有硬币堆，那么两枚两枚的拿显然是更快的。
     *
     * 求单堆硬币最小次数：(x+1)//2
     *
     * 那么，拿完所有硬币堆只需要循环对所有硬币堆都计算一次，然后求和就可以了。
     *
     *
     * class Solution:
     *     def minCount(self, coins: List[int]) -> int:
     *         return sum([(x+1)//2 for x in coins])
     * 复杂度分析
     * 时间复杂度：O(n)O(n)。
     *
     * 空间复杂度：O(n)O(n)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/na-ying-bi/solution/na-ying-bi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
