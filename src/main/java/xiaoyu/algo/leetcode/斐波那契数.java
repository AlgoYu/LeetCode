package xiaoyu.algo.leetcode;

/**
 * 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 */
public class 斐波那契数 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre1 = 0;
        int pre2 = 1;
        int count = 2;
        while (count <= n) {
            int tmp = pre1 + pre2;
            count++;
            pre1 = pre2;
            pre2 = tmp;
        }
        return pre2;
    }
}
