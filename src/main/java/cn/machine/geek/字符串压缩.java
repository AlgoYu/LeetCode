package cn.machine.geek;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内
 */
public class 字符串压缩 {
    public String compressString(String S) {
        StringBuilder builder = new StringBuilder();
        // 上来先做边界检查，如果S字符串为空，或者长度为0，则说明是个无效空串，直接返回空即可。
        if (S == null || S.length() == 0) {
            return builder.toString();
        }
        // 把字符串变成数组，方便遍历，并且提高时间复杂度。
        char[] chars = S.toCharArray();
        // 记录第一个字符，因为上面做了检查，所以至少有一个值，不用担心空值。
        char ch = chars[0];
        // 记录重复次数
        int count = 1;
        // 直接从第二个开始遍历，（计算机都是从0开始）
        for (int i = 1; i < chars.length; i++) {
            // 如果等于ch，说明是相同字符
            if (chars[i] == ch) {
                // 记录+1
                count++;
            } else {
                // 是不同的字符，拼接字符串和重复次数
                builder.append(ch).append(count);
                // 记录当前的字符
                ch = chars[i];
                // 重置重复次数
                count = 1;
            }
        }
        // 循环结束后，如果count大于0，说明最后一个字符没有重复，再加进去
        if (count > 0) {
            builder.append(ch).append(count);
        }
        // 如果压缩后的字符更短，返回压缩后的字符，如果更长，返回原字符。
        return builder.length() < S.length() ? builder.toString() : S;
    }
    /**
     * 方法一：模拟
     * 思路
     *
     * 字符串压缩的方式就是将连续出现的相同字符按照 字符 + 出现次数 压缩。如果压缩后的字符串长度变短，则返回压缩后的字符串，否则保留原来的字符串，所以我们模拟这个过程构建字符串即可。
     *
     * 算法
     *
     * 我们从左往右遍历字符串，用 chch 记录当前要压缩的字符，\textit{cnt}cnt 记录 chch 出现的次数，如果当前枚举到的字符 s[i]s[i] 等于 chch ，我们就更新 \textit{cnt}cnt 的计数，即 cnt = cnt + 1，否则我们按题目要求将 chch 以及 \textit{cnt}cnt 更新到答案字符串 \textit{ans}ans 里，即 ans = ans + ch + cnt，完成对 chch 字符的压缩。随后更新 chch 为 s[i]s[i]，cntcnt 为 11，表示将压缩的字符更改为 s[i]s[i]。
     *
     * 在遍历结束之后，我们就得到了压缩后的字符串 \textit{ans}ans，并将其长度与原串长度进行比较。如果长度没有变短，则返回原串，否则返回压缩后的字符串。
     *
     * C++JavaPython3
     *
     * class Solution {
     *     public String compressString(String S) {
     *         if (S.length() == 0) { // 空串处理
     *             return S;
     *         }
     *         StringBuffer ans = new StringBuffer();
     *         int cnt = 1;
     *         char ch = S.charAt(0);
     *         for (int i = 1; i < S.length(); ++i) {
     *             if (ch == S.charAt(i)) {
     *                 cnt++;
     *             } else {
     *                 ans.append(ch);
     *                 ans.append(cnt);
     *                 ch = S.charAt(i);
     *                 cnt = 1;
     *             }
     *         }
     *         ans.append(ch);
     *         ans.append(cnt);
     *         return ans.length() >= S.length() ? S : ans.toString();
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为字符串的长度，即遍历一次字符串的复杂度。
     *
     * 空间复杂度：O(1)O(1)，只需要常数空间（不包括存储答案 \textit{ans}ans 的空间）存储变量。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/compress-string-lcci/solution/zi-fu-chuan-ya-suo-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
