package xiaoyu.algo.leetcode;

/**
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class 二进制求和 {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a.isEmpty() ? b : a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int n = Math.max(a.length(), b.length());
        int d = 0;
        for (int i = 0; i < n; i++) {
            int ta = ai < 0 ? 0 : a.charAt(ai) - '0';
            int tb = bi < 0 ? 0 : b.charAt(bi) - '0';
            int tm = ta + tb + d;
            d = tm / 2;
            stringBuilder.insert(0, tm % 2);
            ai--;
            bi--;
        }
        if (d != 0) {
            stringBuilder.insert(0, d);
        }
        return stringBuilder.toString();
    }
    /**
     * 题目分析
     * 考虑一个最朴素的方法：先将 aa 和 bb 转化成十进制数，求和后再转化为二进制数。利用 Python 和 Java 自带的高精度运算，我们可以很简单地写出这个程序：
     *
     * Python3Java
     *
     * class Solution {
     *     public String addBinary(String a, String b) {
     *         return Integer.toBinaryString(
     *             Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
     *         );
     *     }
     * }
     * 如果 aa 的位数是 nn，bb 的位数为 mm，这个算法的渐进时间复杂度为 O(n + m)O(n+m)。但是这里非常简单的实现基于 Python 和 Java 本身的高精度功能，在其他的语言中可能并不适用，并且在 Java 中：
     *
     * 如果字符串超过 3333 位，不能转化为 Integer
     * 如果字符串超过 6565 位，不能转化为 Long
     * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
     * 因此，为了适用于长度较大的字符串计算，我们应该使用更加健壮的算法。
     *
     * 方法一：模拟
     * 思路和算法
     *
     * 我们可以借鉴「列竖式」的方法，末尾对齐，逐位相加。在十进制的计算中「逢十进一」，二进制中我们需要「逢二进一」。
     *
     * 具体的，我们可以取 n = \max\{ |a|, |b| \}n=max{∣a∣,∣b∣}，循环 nn 次，从最低位开始遍历。我们使用一个变量 \rm carrycarry 表示上一个位置的进位，初始值为 00。记当前位置对其的两个位为 a_ia
     * i
     * ​
     *   和 b_ib
     * i
     * ​
     *  ，则每一位的答案为 ({\rm carry} + a_i + b_i) \bmod{2}(carry+a
     * i
     * ​
     *  +b
     * i
     * ​
     *  )mod2，下一位的进位为 \lfloor \frac{{\rm carry} + a_i + b_i}{2} \rfloor⌊
     * 2
     * carry+a
     * i
     * ​
     *  +b
     * i
     * ​
     *
     * ​
     *  ⌋。重复上述步骤，直到数字 aa 和 bb 的每一位计算完毕。最后如果 \rm carrycarry 的最高位不为 00，则将最高位添加到计算结果的末尾。
     *
     * 注意，为了让各个位置对齐，你可以先反转这个代表二进制数字的字符串，然后低下标对应低位，高下标对应高位。当然你也可以直接把 aa 和 bb 中短的那一个补 00 直到和长的那个一样长，然后从高位向低位遍历，对应位置的答案按照顺序存入答案字符串内，最终将答案串反转。这里的代码给出第一种的实现。
     *
     * 代码
     *
     * JavaC++Golangc
     *
     * class Solution {
     *     public String addBinary(String a, String b) {
     *         StringBuffer ans = new StringBuffer();
     *
     *         int n = Math.max(a.length(), b.length()), carry = 0;
     *         for (int i = 0; i < n; ++i) {
     *             carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
     *             carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
     *             ans.append((char) (carry % 2 + '0'));
     *             carry /= 2;
     *         }
     *
     *         if (carry > 0) {
     *             ans.append('1');
     *         }
     *         ans.reverse();
     *
     *         return ans.toString();
     *     }
     * }
     * 复杂度分析
     *
     * 假设 n = \max\{ |a|, |b| \}n=max{∣a∣,∣b∣}。
     *
     * 时间复杂度：O(n)O(n)，这里的时间复杂度来源于顺序遍历 aa 和 bb。
     * 空间复杂度：O(1)O(1)，除去答案所占用的空间，这里使用了常数个临时变量。
     * 方法二：位运算
     * 思路和算法
     *
     * 如果不允许使用加减乘除，则可以使用位运算替代上述运算中的一些加减乘除的操作。
     *
     * 如果不了解位运算，可以先了解位运算并尝试练习以下题目：
     *
     * 只出现一次的数字 II
     * 只出现一次的数字 III
     * 数组中两个数的最大异或值
     * 重复的DNA序列
     * 最大单词长度乘积
     * 我们可以设计这样的算法来计算：
     *
     * 把 aa 和 bb 转换成整型数字 xx 和 yy，在接下来的过程中，xx 保存结果，yy 保存进位。
     * 当进位不为 00 时
     * 计算当前 xx 和 yy 的无进位相加结果：answer = x ^ y
     * 计算当前 xx 和 yy 的进位：carry = (x & y) << 1
     * 完成本次循环，更新 x = answer，y = carry
     * 返回 xx 的二进制形式
     * 为什么这个方法是可行的呢？在第一轮计算中，answer 的最后一位是 xx 和 yy 相加之后的结果，carry 的倒数第二位是 xx 和 yy 最后一位相加的进位。接着每一轮中，由于 carry 是由 xx 和 yy 按位与并且左移得到的，那么最后会补零，所以在下面计算的过程中后面的数位不受影响，而每一轮都可以得到一个低 ii 位的答案和它向低 i + 1i+1 位的进位，也就模拟了加法的过程。
     *
     * 代码
     *
     * Python3
     *
     * class Solution:
     *     def addBinary(self, a, b) -> str:
     *         x, y = int(a, 2), int(b, 2)
     *         while y:
     *             answer = x ^ y
     *             carry = (x & y) << 1
     *             x, y = answer, carry
     *         return bin(x)[2:]
     * 复杂度分析
     *
     * 时间复杂度：O(|a| + |b| + X \cdot \max ({|a| + |b|}))O(∣a∣+∣b∣+X⋅max(∣a∣+∣b∣))，字符串转化成数字需要的时间代价为 O(|a| + |b|)O(∣a∣+∣b∣)，计算的时间代价为 O(\max \{ |a|, |b| \})O(max{∣a∣,∣b∣})，XX 为位运算所需的时间，因为这里用到了高精度计算，所以位运算的时间不一定为 O(1)O(1)。
     * 空间复杂度：这里使用了 xx 和 yy 来保存 aa 和 bb 的整数形式，如果用 Python 实现，这里用到了 Python 的高精度功能，实际的空间代价是 O(|a| + |b|)O(∣a∣+∣b∣)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
