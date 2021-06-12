package cn.machine.geek;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length <= 0) {
            return "";
        }
        String temp = strs[0];
        if (null == temp || "".equals(temp)) {
            return "";
        }
        int n = temp.length();
        for (int i = 0; i < strs.length; i++) {
            if (n <= 0) {
                return "";
            }
            for (int j = 0; j < n; j++) {
                if (j >= strs[i].length()) {
                    n = strs[i].length();
                    break;
                }
                if (temp.charAt(j) != strs[i].charAt(j)) {
                    n = j;
                    break;
                }
            }
        }
        if (n > 0) {
            return temp.substring(0, n);
        }
        return "";
    }

    /**
     * 方法一：横向扫描
     * 用 \textit{LCP}(S_1 \ldots S_n)LCP(S
     * 1
     * ​
     *  …S
     * n
     * ​
     *  ) 表示字符串 S_1 \ldots S_nS
     * 1
     * ​
     *  …S
     * n
     * ​
     *   的最长公共前缀。
     *
     * 可以得到以下结论：
     *
     * \textit{LCP}(S_1 \ldots S_n) = \textit{LCP}(\textit{LCP}(\textit{LCP}(S_1, S_2),S_3),\ldots S_n)
     * LCP(S
     * 1
     * ​
     *  …S
     * n
     * ​
     *  )=LCP(LCP(LCP(S
     * 1
     * ​
     *  ,S
     * 2
     * ​
     *  ),S
     * 3
     * ​
     *  ),…S
     * n
     * ​
     *  )
     *
     * 基于该结论，可以得到一种查找字符串数组中的最长公共前缀的简单方法。依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
     *
     *
     *
     * 如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串，因此不需要继续遍历剩下的字符串，直接返回空串即可。
     *
     * JavaC++Python3Golang
     *
     * class Solution {
     *     public String longestCommonPrefix(String[] strs) {
     *         if (strs == null || strs.length == 0) {
     *             return "";
     *         }
     *         String prefix = strs[0];
     *         int count = strs.length;
     *         for (int i = 1; i < count; i++) {
     *             prefix = longestCommonPrefix(prefix, strs[i]);
     *             if (prefix.length() == 0) {
     *                 break;
     *             }
     *         }
     *         return prefix;
     *     }
     *
     *     public String longestCommonPrefix(String str1, String str2) {
     *         int length = Math.min(str1.length(), str2.length());
     *         int index = 0;
     *         while (index < length && str1.charAt(index) == str2.charAt(index)) {
     *             index++;
     *         }
     *         return str1.substring(0, index);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     *
     * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
     *
     * 方法二：纵向扫描
     * 方法一是横向扫描，依次遍历每个字符串，更新最长公共前缀。另一种方法是纵向扫描。纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     *
     *
     *
     * JavaC++Python3Golang
     *
     * class Solution {
     *     public String longestCommonPrefix(String[] strs) {
     *         if (strs == null || strs.length == 0) {
     *             return "";
     *         }
     *         int length = strs[0].length();
     *         int count = strs.length;
     *         for (int i = 0; i < length; i++) {
     *             char c = strs[0].charAt(i);
     *             for (int j = 1; j < count; j++) {
     *                 if (i == strs[j].length() || strs[j].charAt(i) != c) {
     *                     return strs[0].substring(0, i);
     *                 }
     *             }
     *         }
     *         return strs[0];
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     *
     * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
     *
     * 方法三：分治
     * 注意到 \textit{LCP}LCP 的计算满足结合律，有以下结论：
     *
     * \textit{LCP}(S_1 \ldots S_n) = \textit{LCP}(\textit{LCP}(S_1 \ldots S_k), \textit{LCP} (S_{k+1} \ldots S_n))
     * LCP(S
     * 1
     * ​
     *  …S
     * n
     * ​
     *  )=LCP(LCP(S
     * 1
     * ​
     *  …S
     * k
     * ​
     *  ),LCP(S
     * k+1
     * ​
     *  …S
     * n
     * ​
     *  ))
     *
     * 其中 \textit{LCP}(S_1 \ldots S_n)LCP(S
     * 1
     * ​
     *  …S
     * n
     * ​
     *  ) 是字符串 S_1 \ldots S_nS
     * 1
     * ​
     *  …S
     * n
     * ​
     *   的最长公共前缀，1 < k < n1<k<n。
     *
     * 基于上述结论，可以使用分治法得到字符串数组中的最长公共前缀。对于问题 \textit{LCP}(S_i\cdots S_j)LCP(S
     * i
     * ​
     *  ⋯S
     * j
     * ​
     *  )，可以分解成两个子问题 \textit{LCP}(S_i \ldots S_{mid})LCP(S
     * i
     * ​
     *  …S
     * mid
     * ​
     *  ) 与 \textit{LCP}(S_{mid+1} \ldots S_j)LCP(S
     * mid+1
     * ​
     *  …S
     * j
     * ​
     *  )，其中 mid=\frac{i+j}{2}mid=
     * 2
     * i+j
     * ​
     *  。对两个子问题分别求解，然后对两个子问题的解计算最长公共前缀，即为原问题的解。
     *
     *
     *
     * JavaC++Python3Golang
     *
     * class Solution {
     *     public String longestCommonPrefix(String[] strs) {
     *         if (strs == null || strs.length == 0) {
     *             return "";
     *         } else {
     *             return longestCommonPrefix(strs, 0, strs.length - 1);
     *         }
     *     }
     *
     *     public String longestCommonPrefix(String[] strs, int start, int end) {
     *         if (start == end) {
     *             return strs[start];
     *         } else {
     *             int mid = (end - start) / 2 + start;
     *             String lcpLeft = longestCommonPrefix(strs, start, mid);
     *             String lcpRight = longestCommonPrefix(strs, mid + 1, end);
     *             return commonPrefix(lcpLeft, lcpRight);
     *         }
     *     }
     *
     *     public String commonPrefix(String lcpLeft, String lcpRight) {
     *         int minLength = Math.min(lcpLeft.length(), lcpRight.length());
     *         for (int i = 0; i < minLength; i++) {
     *             if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
     *                 return lcpLeft.substring(0, i);
     *             }
     *         }
     *         return lcpLeft.substring(0, minLength);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。时间复杂度的递推式是 T(n)=2 \cdot T(\frac{n}{2})+O(m)T(n)=2⋅T(
     * 2
     * n
     * ​
     *  )+O(m)，通过计算可得 T(n)=O(mn)T(n)=O(mn)。
     *
     * 空间复杂度：O(m \log n)O(mlogn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。空间复杂度主要取决于递归调用的层数，层数最大为 \log nlogn，每层需要 mm 的空间存储返回结果。
     *
     * 方法四：二分查找
     * 显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用 \textit{minLength}minLength 表示字符串数组中的最短字符串的长度，则可以在 [0,\textit{minLength}][0,minLength] 的范围内通过二分查找得到最长公共前缀的长度。每次取查找范围的中间值 \textit{mid}mid，判断每个字符串的长度为 \textit{mid}mid 的前缀是否相同，如果相同则最长公共前缀的长度一定大于或等于 \textit{mid}mid，如果不相同则最长公共前缀的长度一定小于 \textit{mid}mid，通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
     *
     *
     *
     * JavaC++Python3Golang
     *
     * class Solution {
     *     public String longestCommonPrefix(String[] strs) {
     *         if (strs == null || strs.length == 0) {
     *             return "";
     *         }
     *         int minLength = Integer.MAX_VALUE;
     *         for (String str : strs) {
     *             minLength = Math.min(minLength, str.length());
     *         }
     *         int low = 0, high = minLength;
     *         while (low < high) {
     *             int mid = (high - low + 1) / 2 + low;
     *             if (isCommonPrefix(strs, mid)) {
     *                 low = mid;
     *             } else {
     *                 high = mid - 1;
     *             }
     *         }
     *         return strs[0].substring(0, low);
     *     }
     *
     *     public boolean isCommonPrefix(String[] strs, int length) {
     *         String str0 = strs[0].substring(0, length);
     *         int count = strs.length;
     *         for (int i = 1; i < count; i++) {
     *             String str = strs[i];
     *             for (int j = 0; j < length; j++) {
     *                 if (str0.charAt(j) != str.charAt(j)) {
     *                     return false;
     *                 }
     *             }
     *         }
     *         return true;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn \log m)O(mnlogm)，其中 mm 是字符串数组中的字符串的最小长度，nn 是字符串的数量。二分查找的迭代执行次数是 O(\log m)O(logm)，每次迭代最多需要比较 mnmn 个字符，因此总时间复杂度是 O(mn \log m)O(mnlogm)。
     *
     * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
