package cn.machine.geek;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }

    /**
     * 方法二：峰谷法
     * 算法
     * <p>
     * 假设给定的数组为：
     * <p>
     * [7, 1, 5, 3, 6, 4]
     * <p>
     * 如果我们在图表上绘制给定数组中的数字，我们将会得到：
     * <p>
     * <p>
     * <p>
     * 如果我们分析图表，那么我们的兴趣点是连续的峰和谷。
     * <p>
     * 用数学语言描述为：
     * <p>
     * Total Profit= \sum_{i}(height(peak_i)-height(valley_i))
     * TotalProfit=
     * i
     * ∑
     * ​
     * (height(peak
     * i
     * ​
     * )−height(valley
     * i
     * ​
     * ))
     * <p>
     * 关键是我们需要考虑到紧跟谷的每一个峰值以最大化利润。如果我们试图跳过其中一个峰值来获取更多利润，那么我们最终将失去其中一笔交易中获得的利润，从而导致总利润的降低。
     * <p>
     * 例如，在上述情况下，如果我们跳过 peak_ipeak
     * i
     * ​
     * 和 valley_jvalley
     * j
     * ​
     * 试图通过考虑差异较大的点以获取更多的利润，获得的净利润总是会小与包含它们而获得的净利润，因为 CC 总是小于 A+BA+B。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfitOfficial1(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 方法三：简单的一次遍历
     * 算法
     * <p>
     * 该解决方案遵循 方法二 的本身使用的逻辑，但有一些轻微的变化。在这种情况下，我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，而不是在谷之后寻找每个峰值。最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应的成本以及最大利润，但我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，我们获得的总和将是最大利润。这种方法将简化解决方案。
     * 这个例子可以更清楚地展现上述情况：
     * <p>
     * [1, 7, 2, 3, 6, 7, 6, 7]
     * <p>
     * 与此数组对应的图形是：
     * <p>
     * <p>
     * <p>
     * 从上图中，我们可以观察到 A+B+CA+B+C 的和等于差值 DD 所对应的连续峰和谷的高度之差。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfitOfficial2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
