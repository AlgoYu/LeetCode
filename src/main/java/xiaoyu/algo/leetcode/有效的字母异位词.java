package xiaoyu.algo.leetcode;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < sc.length; i++) {
            count[sc[i] - 'a']++;
        }
        for (int i = 0; i < tc.length; i++) {
            if (--count[tc[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 方法一：排序
     * tt 是 ss 的异位词等价于「两个字符串排序后相等」。因此我们可以对字符串 ss 和 tt 分别排序，看排序后的字符串是否相等即可判断。此外，如果 ss 和 tt 的长度不同，tt 必然不是 ss 的异位词。
     *
     * JavaJavaScriptC++GolangC
     *
     * class Solution {
     *     public boolean isAnagram(String s, String t) {
     *         if (s.length() != t.length()) {
     *             return false;
     *         }
     *         char[] str1 = s.toCharArray();
     *         char[] str2 = t.toCharArray();
     *         Arrays.sort(str1);
     *         Arrays.sort(str2);
     *         return Arrays.equals(str1, str2);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n \log n)O(nlogn)，其中 nn 为 ss 的长度。排序的时间复杂度为 O(n\log n)O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)O(n)，因此总体时间复杂度为 O(n \log n+n)=O(n\log n)O(nlogn+n)=O(nlogn)。
     *
     * 空间复杂度：O(\log n)O(logn)。排序需要 O(\log n)O(logn) 的空间复杂度。注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此我们需要额外的 O(n)O(n) 的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：
     *
     * 这依赖于语言的细节；
     * 这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。
     * 方法二：哈希表
     * 从另一个角度考虑，tt 是 ss 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。由于字符串只包含 2626 个小写字母，因此我们可以维护一个长度为 2626 的频次数组 \textit{table}table，先遍历记录字符串 ss 中字符出现的频次，然后遍历字符串 tt，减去 \textit{table}table 中对应的频次，如果出现 \textit{table}[i]<0table[i]<0，则说明 tt 包含一个不在 ss 中的额外字符，返回 \text{false}false 即可。
     *
     * JavaJavaScriptC++GolangC
     *
     * class Solution {
     *     public boolean isAnagram(String s, String t) {
     *         if (s.length() != t.length()) {
     *             return false;
     *         }
     *         int[] table = new int[26];
     *         for (int i = 0; i < s.length(); i++) {
     *             table[s.charAt(i) - 'a']++;
     *         }
     *         for (int i = 0; i < t.length(); i++) {
     *             table[t.charAt(i) - 'a']--;
     *             if (table[t.charAt(i) - 'a'] < 0) {
     *                 return false;
     *             }
     *         }
     *         return true;
     *     }
     * }
     * 对于进阶问题，\text{Unicode}Unicode 是为了解决传统字符编码的局限性而产生的方案，它为每个语言中的字符规定了一个唯一的二进制编码。而 \text{Unicode}Unicode 中可能存在一个字符对应多个字节的问题，为了让计算机知道多少字节表示一个字符，面向传输的编码方式的 \text{UTF}-8UTF−8 和 \text{UTF}-16UTF−16 也随之诞生逐渐广泛使用，具体相关的知识读者可以继续查阅相关资料拓展视野，这里不再展开。
     *
     * 回到本题，进阶问题的核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可。同时读者需要注意 \text{Unicode}Unicode 一个字符可能对应多个字节的问题，不同语言对于字符串读取处理的方式是不同的。
     *
     * JavaGolang
     *
     * class Solution {
     *     public boolean isAnagram(String s, String t) {
     *         if (s.length() != t.length()) {
     *             return false;
     *         }
     *         Map<Character, Integer> table = new HashMap<Character, Integer>();
     *         for (int i = 0; i < s.length(); i++) {
     *             char ch = s.charAt(i);
     *             table.put(ch, table.getOrDefault(ch, 0) + 1);
     *         }
     *         for (int i = 0; i < t.length(); i++) {
     *             char ch = t.charAt(i);
     *             table.put(ch, table.getOrDefault(ch, 0) - 1);
     *             if (table.get(ch) < 0) {
     *                 return false;
     *             }
     *         }
     *         return true;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为 ss 的长度。
     *
     * 空间复杂度：O(S)O(S)，其中 SS 为字符集大小，此处 S=26S=26。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
