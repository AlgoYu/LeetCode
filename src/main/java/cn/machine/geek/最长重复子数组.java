package cn.machine.geek;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class 最长重复子数组 {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] != B[j - 1]) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
    /**
     * 写在前面
     * 本题要求我们计算两个数组的最长公共子数组。需要注意到数组长度不超过 10001000，且子数组在原数组中连续。
     *
     * 容易想到一个暴力解法，即枚举数组 A 中的起始位置 i 与数组 B 中的起始位置 j，然后计算 A[i:] 与 B[j:] 的最长公共前缀 k。最终答案即为所有的最长公共前缀的最大值。
     *
     * 这里借用了 Python 表示数组的方法，A[i:] 表示数组 A 中索引 i 到数组末尾的范围对应的子数组。
     *
     * 这个过程的伪代码如下：
     *
     *
     * ans = 0
     * for i in [0 .. A.length - 1]
     *     for j in [0 .. B.length - 1]
     *         k = 0
     *         while (A[i+k] == B[j+k]) do   # and i+k < A.length etc.
     *             k += 1
     *         end while
     *         ans = max(ans, k)
     *     end for
     * end for
     * 虽然该暴力解法的最坏时间复杂度为 O(n^3)O(n
     * 3
     *  )，但通过观察该暴力解法，我们可以提出几个时间复杂度更优秀的解法。
     *
     * 方法一：动态规划
     * 思路及算法
     *
     * 暴力解法的过程中，我们发现最坏情况下对于任意 i 与 j ，A[i] 与 B[j] 比较了 \min(i + 1, j + 1)min(i+1,j+1) 次。这也是导致了该暴力解法时间复杂度过高的根本原因。
     *
     * 不妨设 A 数组为 [1, 2, 3]，B 两数组为为 [1, 2, 4] ，那么在暴力解法中 A[2] 与 B[2] 被比较了三次。这三次比较分别是我们计算 A[0:] 与 B[0:] 最长公共前缀、 A[1:] 与 B[1:] 最长公共前缀以及 A[2:] 与 B[2:] 最长公共前缀时产生的。
     *
     * 我们希望优化这一过程，使得任意一对 A[i] 和 B[j] 都只被比较一次。这样我们自然而然想到利用这一次的比较结果。如果 A[i] == B[j]，那么我们知道 A[i:] 与 B[j:] 的最长公共前缀为 A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一，否则我们知道 A[i:] 与 B[j:] 的最长公共前缀为零。
     *
     * 这样我们就可以提出动态规划的解法：令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
     *
     * 这里借用了 Python 表示数组的方法，A[i:] 表示数组 A 中索引 i 到数组末尾的范围对应的子数组。
     *
     * 考虑到这里 dp[i][j] 的值从 dp[i + 1][j + 1] 转移得到，所以我们需要倒过来，首先计算 dp[len(A) - 1][len(B) - 1]，最后计算 dp[0][0]。
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public int findLength(int[] A, int[] B) {
     *         int n = A.length, m = B.length;
     *         int[][] dp = new int[n + 1][m + 1];
     *         int ans = 0;
     *         for (int i = n - 1; i >= 0; i--) {
     *             for (int j = m - 1; j >= 0; j--) {
     *                 dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
     *                 ans = Math.max(ans, dp[i][j]);
     *             }
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度： O(N \times M)O(N×M)。
     *
     * 空间复杂度： O(N \times M)O(N×M)。
     *
     * N 表示数组 A 的长度，M 表示数组 B 的长度。
     *
     * 空间复杂度还可以再优化，利用滚动数组可以优化到 O(\min(N,M))O(min(N,M))。
     *
     * 方法二：滑动窗口
     * 思路及算法
     *
     * 我们注意到之所以两位置会比较多次，是因为重复子数组在两个数组中的位置可能不同。以 A = [3, 6, 1, 2, 4], B = [7, 1, 2, 9] 为例，它们的最长重复子数组是 [1, 2]，在 A 与 B 中的开始位置不同。
     *
     * 但如果我们知道了开始位置，我们就可以根据它们将 A 和 B 进行「对齐」，即：
     *
     *
     * A = [3, 6, 1, 2, 4]
     * B =    [7, 1, 2, 9]
     *            ↑  ↑
     * 此时，最长重复子数组在 A 和 B 中的开始位置相同，我们就可以对这两个数组进行一次遍历，得到子数组的长度，伪代码如下：
     *
     *
     * ans = 0
     * len = min(A.length, B.length)
     * k = 0
     * for i in [0 .. len - 1] do
     *     if (A[i] == B[i]) then
     *         k = k + 1
     *     else
     *         k = 0
     *     end if
     *     ans = max(ans, k)
     * end for
     * 注意这里指定了 A[i] 对齐 B[i]，在实际代码实现中会通过指定初始位置 addA 与 addB 的方式来对齐，因此表达式会略有差别。
     *
     * 我们可以枚举 A 和 B 所有的对齐方式。对齐的方式有两类：第一类为 A 不变，B 的首元素与 A 中的某个元素对齐；第二类为 B 不变，A 的首元素与 B 中的某个元素对齐。对于每一种对齐方式，我们计算它们相对位置相同的重复子数组即可。
     *
     *
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public int findLength(int[] A, int[] B) {
     *         int n = A.length, m = B.length;
     *         int ret = 0;
     *         for (int i = 0; i < n; i++) {
     *             int len = Math.min(m, n - i);
     *             int maxlen = maxLength(A, B, i, 0, len);
     *             ret = Math.max(ret, maxlen);
     *         }
     *         for (int i = 0; i < m; i++) {
     *             int len = Math.min(n, m - i);
     *             int maxlen = maxLength(A, B, 0, i, len);
     *             ret = Math.max(ret, maxlen);
     *         }
     *         return ret;
     *     }
     *
     *     public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
     *         int ret = 0, k = 0;
     *         for (int i = 0; i < len; i++) {
     *             if (A[addA + i] == B[addB + i]) {
     *                 k++;
     *             } else {
     *                 k = 0;
     *             }
     *             ret = Math.max(ret, k);
     *         }
     *         return ret;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度： O((N + M) \times \min(N, M))O((N+M)×min(N,M))。
     *
     * 空间复杂度： O(1)O(1)。
     *
     * N 表示数组 A 的长度，M 表示数组 B 的长度。
     *
     * 方法三：二分查找 + 哈希
     * 思路及算法
     *
     * 如果数组 A 和 B 有一个长度为 k 的公共子数组，那么它们一定有长度为 j <= k 的公共子数组。这样我们可以通过二分查找的方法找到最大的 k。
     *
     * 而为了优化时间复杂度，在二分查找的每一步中，我们可以考虑使用哈希的方法来判断数组 A 和 B 中是否存在相同特定长度的子数组。
     *
     * 注意到序列内元素值小于 100100 ，我们使用 Rabin-Karp 算法来对序列进行哈希。具体地，我们制定一个素数 base，那么序列 S 的哈希值为：
     *
     * \mathrm{hash}(S) = \sum_{i=0}^{|S|-1} \textit{base}^{|S|-(i+1)} \times S[i]
     * hash(S)=
     * i=0
     * ∑
     * ∣S∣−1
     * ​
     *  base
     * ∣S∣−(i+1)
     *  ×S[i]
     *
     * 形象地说，就是把 S 看成一个类似 base 进制的数（左侧为高位，右侧为低位），它的十进制值就是这个它的哈希值。由于这个值一般会非常大，因此会将它对另一个素数 mod 取模。
     *
     * 当我们要在一个序列 S​ 中算出所有长度为 len 的子序列的哈希值时，我们可以用类似滑动窗口的方法，在线性时间内得到这些子序列的哈希值。例如，如果我们当前得到了 S[0:len] 的哈希值，希望算出 S[1:len+1] 的哈希值时，有下面这个公式：
     *
     * \mathrm{hash}(S[1:len+1]) = (\mathrm{hash}(S[0:len]) - \textit{base}^{len-1} \times S[0]) \times \textit{base} + S[len]
     * hash(S[1:len+1])=(hash(S[0:len])−base
     * len−1
     *  ×S[0])×base+S[len]
     *
     * 这里借用了 Python 表示数组的方法，A[i:j] 表示数组 A 中索引 i 到索引 j - 1 的范围对应的子数组。
     *
     * 公式的含义为，删去最高位 S[0]，其余位自动进一，并补上最低位 S[len]。
     *
     * 在二分查找的每一步中，我们使用哈希表分别存储这两个数组的所有长度为 len 的子数组的哈希值，将它们的哈希值进行比对，如果两序列存在相同的哈希值，则认为两序列存在相同的子数组。为了防止哈希碰撞，我们也可以在发现两个子数组的哈希值相等时，进一步校验它们本身是否确实相同，以确保正确性。但该方法在本题中很难发生哈希碰撞，因此略去进一步校验的部分。
     *
     * 代码
     *
     * C++JavaPython3Golang
     *
     * class Solution {
     *     int mod = 1000000009;
     *     int base = 113;
     *
     *     public int findLength(int[] A, int[] B) {
     *         int left = 1, right = Math.min(A.length, B.length) + 1;
     *         while (left < right) {
     *             int mid = (left + right) >> 1;
     *             if (check(A, B, mid)) {
     *                 left = mid + 1;
     *             } else {
     *                 right = mid;
     *             }
     *         }
     *         return left - 1;
     *     }
     *
     *     public boolean check(int[] A, int[] B, int len) {
     *         long hashA = 0;
     *         for (int i = 0; i < len; i++) {
     *             hashA = (hashA * base + A[i]) % mod;
     *         }
     *         Set<Long> bucketA = new HashSet<Long>();
     *         bucketA.add(hashA);
     *         long mult = qPow(base, len - 1);
     *         for (int i = len; i < A.length; i++) {
     *             hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
     *             bucketA.add(hashA);
     *         }
     *         long hashB = 0;
     *         for (int i = 0; i < len; i++) {
     *             hashB = (hashB * base + B[i]) % mod;
     *         }
     *         if (bucketA.contains(hashB)) {
     *             return true;
     *         }
     *         for (int i = len; i < B.length; i++) {
     *             hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
     *             if (bucketA.contains(hashB)) {
     *                 return true;
     *             }
     *         }
     *         return false;
     *     }
     *
     *     // 使用快速幂计算 x^n % mod 的值
     *     public long qPow(long x, long n) {
     *         long ret = 1;
     *         while (n != 0) {
     *             if ((n & 1) != 0) {
     *                 ret = ret * x % mod;
     *             }
     *             x = x * x % mod;
     *             n >>= 1;
     *         }
     *         return ret;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O\big((M+N) \log{(\min(M, N))}\big)O((M+N)log(min(M,N)))。
     *
     * 空间复杂度：O(N)O(N)。
     *
     * N 表示数组 A 的长度，M 表示数组 B 的长度。二分查找为对数时间复杂度，计算哈希值的时间复杂度为 O(M+N)O(M+N)，哈希检测的时间复杂度为 O(1)O(1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
