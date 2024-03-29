package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 */
public class 判断句子是否为全字母句 {
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            count[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
