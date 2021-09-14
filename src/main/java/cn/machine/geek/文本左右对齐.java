package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class 文本左右对齐 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int right = 0, n = words.length;
        for (; ; ) {
            // 记录第一个单词
            int left = right;
            int sumLen = 0;
            // 如果还可以放就一直加，但要记得每个单词之间至少要有一个空格
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }
            StringBuilder sb = new StringBuilder();
            // 如果是最后一行
            if (right == n) {
                sb.append(join(words, left, right, " "));
                sb.append(blank(maxWidth - sb.length()));
                result.add(sb.toString());
                return result;
            }
            // 不是最后一行
            int sumWord = right - left; // 单词总数
            // 只有一个单词
            if (sumWord == 1) {
                sb.append(words[left]);
                sb.append(blank(maxWidth - sb.length()));
                result.add(sb.toString());
                continue;
            }
            // 多个单词
            int sumSpace = maxWidth - sumLen; // 总空格
            int avgSpace = sumSpace / (sumWord - 1); // 平均空格
            int extraSpace = sumSpace % (sumWord - 1); //余数空格
            // 如果分配不均匀的话，左边的空格要比右边多一些
            sb.append(join(words, left, left + extraSpace + 1, blank(avgSpace + 1)));
            sb.append(blank(avgSpace));
            sb.append(join(words, left + extraSpace + 1, right, blank(avgSpace)));
            result.add(sb.toString());
        }
    }

    private String blank(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(' ');
            n--;
        }
        return sb.toString();
    }

    private StringBuilder join(String[] words, int left, int right, String space) {
        StringBuilder sb = new StringBuilder(words[left++]);
        while (left < right) {
            sb.append(space).append(words[left]);
            left++;
        }
        return sb;
    }
}
