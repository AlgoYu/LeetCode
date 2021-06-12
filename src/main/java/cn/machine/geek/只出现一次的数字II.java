package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
 */
public class 只出现一次的数字II {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
    /**
     * 方法一：哈希表
     * 思路与算法
     *
     * 我们可以使用哈希映射统计数组中每个元素的出现次数。对于哈希映射中的每个键值对，键表示一个元素，值表示其出现的次数。
     *
     * 在统计完成后，我们遍历哈希映射即可找出只出现一次的元素。
     *
     * 代码
     *
     * C++JavaPython3JavaScriptGolangC
     *
     * class Solution {
     *     public int singleNumber(int[] nums) {
     *         Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
     *         for (int num : nums) {
     *             freq.put(num, freq.getOrDefault(num, 0) + 1);
     *         }
     *         int ans = 0;
     *         for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
     *             int num = entry.getKey(), occ = entry.getValue();
     *             if (occ == 1) {
     *                 ans = num;
     *                 break;
     *             }
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组的长度。
     *
     * 空间复杂度：O(n)O(n)。哈希映射中包含最多 \lfloor n/3 \rfloor + 1⌊n/3⌋+1 个元素，即需要的空间为 O(n)O(n)。
     *
     * 方法二：依次确定每一个二进制位
     * 思路与算法
     *
     * 为了方便叙述，我们称「只出现了一次的元素」为「答案」。
     *
     * 由于数组中的元素都在 \texttt{int}int（即 3232 位整数）范围内，因此我们可以依次计算答案的每一个二进制位是 00 还是 11。
     *
     * 具体地，考虑答案的第 ii 个二进制位（ii 从 00 开始编号），它可能为 00 或 11。对于数组中非答案的元素，每一个元素都出现了 33 次，对应着第 ii 个二进制位的 33 个 00 或 33 个 11，无论是哪一种情况，它们的和都是 33 的倍数（即和为 00 或 33）。因此：
     *
     * 答案的第 ii 个二进制位就是数组中所有元素的第 ii 个二进制位之和除以 33 的余数。
     *
     * 这样一来，对于数组中的每一个元素 xx，我们使用位运算 \texttt{(x >> i) \& 1}(x >> i) & 1 得到 xx 的第 ii 个二进制位，并将它们相加再对 33 取余，得到的结果一定为 00 或 11，即为答案的第 ii 个二进制位。
     *
     * 细节
     *
     * 需要注意的是，如果使用的语言对「有符号整数类型」和「无符号整数类型」没有区分，那么可能会得到错误的答案。这是因为「有符号整数类型」（即 \texttt{int}int 类型）的第 3131 个二进制位（即最高位）是补码意义下的符号位，对应着 -2^{31}−2
     * 31
     *  ，而「无符号整数类型」由于没有符号，第 3131 个二进制位对应着 2^{31}2
     * 31
     *  。因此在某些语言（例如 \texttt{Python}Python）中需要对最高位进行特殊判断。
     *
     * 代码
     *
     * C++JavaPython3JavaScriptGolangC
     *
     * class Solution {
     *     public int singleNumber(int[] nums) {
     *         int ans = 0;
     *         for (int i = 0; i < 32; ++i) {
     *             int total = 0;
     *             for (int num: nums) {
     *                 total += ((num >> i) & 1);
     *             }
     *             if (total % 3 != 0) {
     *                 ans |= (1 << i);
     *             }
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n \log C)O(nlogC)，其中 nn 是数组的长度，CC 是元素的数据范围，在本题中 \log C=\log 2^{32} = 32logC=log2
     * 32
     *  =32，也就是我们需要遍历第 0\sim310∼31 个二进制位。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 方法三：数字电路设计
     * 说明
     *
     * 方法三以及后续进行优化的方法四需要读者有一定的数字电路设计的基础。读者需要对以下知识：
     *
     * 简单的门电路（例如与门、异或门等）
     *
     * 给定数字电路输入和输出（真值表），使用门电路设计出一种满足要求的数字电路结构
     *
     * 有一定的了解。
     *
     * 门电路表示
     *
     * 我们将会用到四种门电路，使用的符号如下：
     *
     * 非门：我们用 A'A
     * ′
     *   表示输入为 AA 的非门的输出；
     *
     * 与门：我们用 ABAB 表示输入为 AA 和 BB 的与门的输出。由于「与运算」具有结合律，因此如果同时用了多个与门（例如将 AA 和 BB 进行与运算后，再和 CC 进行与运算），我们可以将多个输入写在一起（例如 ABCABC）；
     *
     * 或门：我们用 A+BA+B 表示输入为 AA 和 BB 的或门的输出。同样地，多个或门可以写在一起（例如 A+B+CA+B+C）；
     *
     * 异或门：我们用 A\oplus BA⊕B 表示输入为 AA 和 BB 的异或门的输出。同样的，多个异或门可以写在一起（例如 A\oplus B\oplus CA⊕B⊕C）。
     *
     * 思路与算法
     *
     * 在方法二中，我们是依次处理每一个二进制位的，那么时间复杂度中就引入了 O(\log C)O(logC) 这一项。既然我们在对两个整数进行普通的二元运算时，都是将它们看成整体进行处理的，那么我们是否能以普通的二元运算为基础，同时处理所有的二进制位？
     *
     * 答案是可以的。我们可以使用一个「黑盒」存储当前遍历过的所有整数。「黑盒」的第 ii 位为 \{ 0, 1, 2 \}{0,1,2} 三者之一，表示当前遍历过的所有整数的第 ii 位之和除以 33 的余数。但由于二进制表示中只有 00 和 11 而没有 22，因此我们可以考虑在「黑盒」中使用两个整数来进行存储，即：
     *
     * 黑盒中存储了两个整数 aa 和 bb，且会有三种情况：
     *
     * aa 的第 ii 位为 00 且 bb 的第 ii 位为 00，表示 00；
     * aa 的第 ii 位为 00 且 bb 的第 ii 位为 11，表示 11；
     * aa 的第 ii 位为 11 且 bb 的第 ii 位为 00，表示 22。
     * 为了方便叙述，我们用 (00)(00) 表示 aa 的第 ii 位为 00 且 bb 的第 ii 位为 00，其余的情况类似。
     *
     * 当我们遍历到一个新的整数 xx 时，对于 xx 的第 ii 位 x_ix
     * i
     * ​
     *  ，如果 x_i=0x
     * i
     * ​
     *  =0，那么 aa 和 bb 的第 ii 位不变；如果 x_i=1x
     * i
     * ​
     *  =1，那么 aa 和 bb 的第 ii 位按照 (00)\to(01)\to(10)\to(00)(00)→(01)→(10)→(00) 这一循环进行变化。因此我们可以得出下面的真值表：
     *
     * (a_i ~ b_i)(a
     * i
     * ​
     *   b
     * i
     * ​
     *  )	x_ix
     * i
     * ​
     *  	新的 (a_i ~ b_i)(a
     * i
     * ​
     *   b
     * i
     * ​
     *  )
     * 0000	00	0000
     * 0000	11	0101
     * 0101	00	0101
     * 0101	11	1010
     * 1010	00	1010
     * 1010	11	0000
     * 当我们考虑输出为 a_ia
     * i
     * ​
     *   时：
     *
     * (a_i ~ b_i)(a
     * i
     * ​
     *   b
     * i
     * ​
     *  )	x_ix
     * i
     * ​
     *  	新的 a_ia
     * i
     * ​
     *
     * 0000	00	00
     * 0000	11	00
     * 0101	00	00
     * 0101	11	11
     * 1010	00	11
     * 1010	11	00
     * 根据真值表可以设计出电路：
     *
     * a_i = a_i'b_ix_i + a_ib_i'x_i'
     * a
     * i
     * ​
     *  =a
     * i
     * ′
     * ​
     *  b
     * i
     * ​
     *  x
     * i
     * ​
     *  +a
     * i
     * ​
     *  b
     * i
     * ′
     * ​
     *  x
     * i
     * ′
     * ​
     *
     *
     * 当我们考虑输出为 b_ib
     * i
     * ​
     *   时：
     *
     * (a_i ~ b_i)(a
     * i
     * ​
     *   b
     * i
     * ​
     *  )	x_ix
     * i
     * ​
     *  	新的 b_ib
     * i
     * ​
     *
     * 0000	00	00
     * 0000	11	11
     * 0101	00	11
     * 0101	11	00
     * 1010	00	00
     * 1010	11	00
     * 根据真值表可以设计出电路：
     *
     * b_i = a_i'b_i'x_i + a_i'b_ix_i' = a_i'(b_i \oplus x_i)
     * b
     * i
     * ​
     *  =a
     * i
     * ′
     * ​
     *  b
     * i
     * ′
     * ​
     *  x
     * i
     * ​
     *  +a
     * i
     * ′
     * ​
     *  b
     * i
     * ​
     *  x
     * i
     * ′
     * ​
     *  =a
     * i
     * ′
     * ​
     *  (b
     * i
     * ​
     *  ⊕x
     * i
     * ​
     *  )
     *
     * 将上面的电路逻辑运算转换为等价的整数位运算，最终的转换规则即为：
     *
     * \begin{cases} \texttt{a = (\textasciitilde a \& b \& x) | (a \& \textasciitilde b \& \textasciitilde x)} \\ \texttt{b = \textasciitilde a \& (b\^ x)} \end{cases}
     * {
     * a = (~a & b & x) | (a & ~b & ~x)
     * b = ~a & (b
     *  
     * ˆ
     *  x)
     * ​
     *
     *
     * 其中 \texttt{\textasciitilde, \&, |, \^ }~, &, |, 
     *  
     * ˆ
     *   分别表示按位非、与、或、异或运算。
     *
     * 当我们遍历完数组中的所有元素后，(a_i b_i)(a
     * i
     * ​
     *  b
     * i
     * ​
     *  ) 要么是 (00)(00)，表示答案的第 ii 位是 00；要么是 (01)(01)，表示答案的第 ii 位是 11。因此我们只需要返回 bb 作为答案即可。
     *
     * 细节
     *
     * 由于电路中的 a_ia
     * i
     * ​
     *   和 b_ib
     * i
     * ​
     *   是「同时」得出结果的，因此我们在计算 aa 和 bb 时，需要使用临时变量暂存它们之前的值，再使用转换规则进行计算。
     *
     * 代码
     *
     * C++JavaPython3JavaScriptGolang
     *
     * class Solution {
     *     public int singleNumber(int[] nums) {
     *         int a = 0, b = 0;
     *         for (int num : nums) {
     *             int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
     *             a = aNext;
     *             b = bNext;
     *         }
     *         return b;
     *     }
     * }
     * C
     *
     * int singleNumber(int *nums, int numsSize) {
     *     int a = 0, b = 0;
     *     for (int i = 0; i < numsSize; i++) {
     *         int tmp_a = (~a & b & nums[i]) | (a & ~b & ~nums[i]);
     *         int tmp_b = ~a & (b ^ nums[i]);
     *         a = tmp_a;
     *         b = tmp_b;
     *     }
     *     return b;
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组的长度。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 方法四：数字电路设计优化
     * 思路与算法
     *
     * 我们发现方法三中计算 bb 的规则较为简单，而 aa 的规则较为麻烦，因此可以将「同时计算」改为「分别计算」，即先计算出 bb，再拿新的 bb 值计算 aa。
     *
     * 对于原始的真值表：
     *
     * (a_i ~ b_i)(a
     * i
     * ​
     *   b
     * i
     * ​
     *  )	x_ix
     * i
     * ​
     *  	新的 (a_i ~ b_i)(a
     * i
     * ​
     *   b
     * i
     * ​
     *  )
     * 0000	00	0000
     * 0000	11	0101
     * 0101	00	0101
     * 0101	11	1010
     * 1010	00	1010
     * 1010	11	0000
     * 我们将第一列的 b_ib
     * i
     * ​
     *   替换新的 b_ib
     * i
     * ​
     *   即可得到：
     *
     * (a_i,(a
     * i
     * ​
     *  , 新的 b_i)b
     * i
     * ​
     *  )	x_ix
     * i
     * ​
     *  	新的 a_ia
     * i
     * ​
     *
     * 0000	00	00
     * 0101	11	00
     * 0101	00	00
     * 0000	11	11
     * 1010	00	11
     * 1010	11	00
     * 根据真值表可以设计出电路：
     *
     * a_i = a_i'b_i'x_i + a_ib_i'x_i' = b_i'(a_i \oplus x_i)
     * a
     * i
     * ​
     *  =a
     * i
     * ′
     * ​
     *  b
     * i
     * ′
     * ​
     *  x
     * i
     * ​
     *  +a
     * i
     * ​
     *  b
     * i
     * ′
     * ​
     *  x
     * i
     * ′
     * ​
     *  =b
     * i
     * ′
     * ​
     *  (a
     * i
     * ​
     *  ⊕x
     * i
     * ​
     *  )
     *
     * 这样就与 b_ib
     * i
     * ​
     *   的电路逻辑非常类似了。最终的转换规则即为：
     *
     * \begin{cases} \texttt{b = \textasciitilde a \& (b\^ x)} \\ \texttt{a = \textasciitilde b \& (a\^ x)} \end{cases}
     * {
     * b = ~a & (b
     *  
     * ˆ
     *  x)
     * a = ~b & (a
     *  
     * ˆ
     *  x)
     * ​
     *
     *
     * 需要注意先计算 bb，再计算 aa。
     *
     * 代码
     *
     * C++JavaPython3JavaScriptGolang
     *
     * class Solution {
     *     public int singleNumber(int[] nums) {
     *         int a = 0, b = 0;
     *         for (int num : nums) {
     *             b = ~a & (b ^ num);
     *             a = ~b & (a ^ num);
     *         }
     *         return b;
     *     }
     * }
     * C
     *
     * int singleNumber(int *nums, int numsSize) {
     *     int a = 0, b = 0;
     *     for (int i = 0; i < numsSize; i++) {
     *         b = ~a & (b ^ nums[i]);
     *         a = ~b & (a ^ nums[i]);
     *     }
     *     return b;
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是数组的长度。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
