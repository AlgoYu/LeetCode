package xiaoyu.algo.leetcode;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 */
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int space = s.length() - 1;
        while (space >= 0 && chars[space] == ' ') space--;
        int word = space;
        while (word >= 0 && chars[word] != ' ') {
            word--;
        }
        return space - word;
    }
    /**
     * 标签：字符串遍历
     * 从字符串末尾开始向前遍历，其中主要有两种情况
     * 第一种情况，以字符串"Hello World"为例，从后向前遍历直到遍历到头或者遇到空格为止，即为最后一个单词"World"的长度5
     * 第二种情况，以字符串"Hello World "为例，需要先将末尾的空格过滤掉，再进行第一种情况的操作，即认为最后一个单词为"World"，长度为5
     * 所以完整过程为先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
     * 时间复杂度：O(n)，n为结尾空格和结尾单词总体长度
     * 代码
     * JavaJavaScript
     *
     * class Solution {
     *     public int lengthOfLastWord(String s) {
     *         int end = s.length() - 1;
     *         while(end >= 0 && s.charAt(end) == ' ') end--;
     *         if(end < 0) return 0;
     *         int start = end;
     *         while(start >= 0 && s.charAt(start) != ' ') start--;
     *         return end - start;
     *     }
     * }
     * 画解
     *
     * 1 / 7
     *
     * 想看大鹏画解更多高频面试题，欢迎阅读大鹏的 LeetBook：《画解剑指 Offer 》，O(∩_∩)O
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
