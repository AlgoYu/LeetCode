package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class 字母大小写全排列 {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        return full(list, s.toCharArray(), 0, new StringBuilder());
    }

    public List<String> full(List<String> result, char[] chars, int index, StringBuilder builder) {
        if (index >= chars.length) {
            result.add(builder.toString());
            return result;
        }
        char ch = chars[index];
        if (ch >= '0' && ch <= '9') {
            builder.append(ch);
            full(result, chars, index + 1, builder);
            builder.delete(builder.length() - 1, builder.length());
        } else {
            builder.append(ch);
            full(result, chars, index + 1, builder);
            builder.delete(builder.length() - 1, builder.length());

            builder.append(charSwitch(ch));
            full(result, chars, index + 1, builder);
            builder.delete(builder.length() - 1, builder.length());
        }
        return result;
    }

    public char charSwitch(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 32);
        } else {
            return (char) (ch + 32);
        }
    }
}
