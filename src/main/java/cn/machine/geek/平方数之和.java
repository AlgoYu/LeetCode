package cn.machine.geek;

/**
 * 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class 平方数之和 {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = (int) Math.sqrt(c);
        int n = 0;
        while (low <= high) {
            n = low * low + high * high;
            if (n == c) return true;
            if (n < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
    /**
     * 前言
     * 对于给定的非负整数 cc，需要判断是否存在整数 aa 和 bb，使得 a^2 + b^2 = ca
     * 2
     *  +b
     * 2
     *  =c。可以枚举 aa 和 bb 所有可能的情况，时间复杂度为 O(c^2)O(c
     * 2
     *  )。但是暴力枚举有一些情况是没有必要的。例如：当 c = 20c=20 时，当 a = 1a=1 的时候，枚举 bb 的时候，只需要枚举到 b = 5b=5 就可以结束了，这是因为 1^2 + 5^2 = 25 > 201
     * 2
     *  +5
     * 2
     *  =25>20。当 b > 5b>5 时，一定有 1^2 + b^2 > 201
     * 2
     *  +b
     * 2
     *  >20。
     *
     * 注意到这一点，可以使用 \texttt{sqrt}sqrt 函数或者双指针降低时间复杂度。
     *
     * 方法一：使用 \texttt{sqrt}sqrt 函数
     * 在枚举 aa 的同时，使用 \texttt{sqrt}sqrt 函数找出 bb。注意：本题 cc 的取值范围在 [0,2^{31} - 1][0,2
     * 31
     *  −1]，因此在计算的过程中可能会发生 \texttt{int}int 型溢出的情况，需要使用 \texttt{long}long 型避免溢出。
     *
     * JavaJavaScriptGolangC++C
     *
     * class Solution {
     *     public boolean judgeSquareSum(int c) {
     *         for (long a = 0; a * a <= c; a++) {
     *             double b = Math.sqrt(c - a * a);
     *             if (b == (int) b) {
     *                 return true;
     *             }
     *         }
     *         return false;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\sqrt{c})O(
     * c
     * ​
     *  )。枚举 aa 的时间复杂度为 O(\sqrt{c})O(
     * c
     * ​
     *  )，对于每个 aa 的值，可在 O(1)O(1) 的时间内寻找 bb。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 方法二：双指针
     * 不失一般性，可以假设 a \le ba≤b。初始时 a = 0a=0，b = \sqrt{c}b=
     * c
     * ​
     *  ，进行如下操作：
     *
     * 如果 a^2 + b^2 = ca
     * 2
     *  +b
     * 2
     *  =c，我们找到了题目要求的一个解，返回 \text{true}true；
     * 如果 a^2 + b^2 < ca
     * 2
     *  +b
     * 2
     *  <c，此时需要将 aa 的值加 11，继续查找；
     * 如果 a^2 + b^2 > ca
     * 2
     *  +b
     * 2
     *  >c，此时需要将 bb 的值减 11，继续查找。
     * 当 a = ba=b 时，结束查找，此时如果仍然没有找到整数 aa 和 bb 满足 a^2 + b^2 = ca
     * 2
     *  +b
     * 2
     *  =c，则说明不存在题目要求的解，返回 \text{false}false。
     *
     * JavaJavaScriptGolangC++C
     *
     * class Solution {
     *     public boolean judgeSquareSum(int c) {
     *         long left = 0;
     *         long right = (long) Math.sqrt(c);
     *         while (left <= right) {
     *             long sum = left * left + right * right;
     *             if (sum == c) {
     *                 return true;
     *             } else if (sum > c) {
     *                 right--;
     *             } else {
     *                 left++;
     *             }
     *         }
     *         return false;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\sqrt{c})O(
     * c
     * ​
     *  )。最坏情况下 aa 和 bb 一共枚举了 00 到 \sqrt{c}
     * c
     * ​
     *   里的所有整数。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 方法三：数学
     * 费马平方和定理告诉我们：
     *
     * 一个非负整数 cc 如果能够表示为两个整数的平方和，当且仅当 cc 的所有形如 4k + 34k+3 的质因子的幂均为偶数。
     *
     * 证明请见 这里。
     *
     * 因此我们需要对 cc 进行质因数分解，再判断所有形如 4k + 34k+3 的质因子的幂是否均为偶数即可。
     *
     * JavaJavaScriptGolangC++C
     *
     * class Solution {
     *     public boolean judgeSquareSum(int c) {
     *         for (int base = 2; base * base <= c; base++) {
     *             // 如果不是因子，枚举下一个
     *             if (c % base != 0) {
     *                 continue;
     *             }
     *
     *             // 计算 base 的幂
     *             int exp = 0;
     *             while (c % base == 0) {
     *                 c /= base;
     *                 exp++;
     *             }
     *
     *             // 根据 Sum of two squares theorem 验证
     *             if (base % 4 == 3 && exp % 2 != 0) {
     *                 return false;
     *             }
     *         }
     *
     *       	// 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
     *       	// 因此在退出循环以后需要再做一次判断
     *         return c % 4 != 3;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\sqrt{c})O(
     * c
     * ​
     *  )。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers/solution/ping-fang-shu-zhi-he-by-leetcode-solutio-8ydl/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
