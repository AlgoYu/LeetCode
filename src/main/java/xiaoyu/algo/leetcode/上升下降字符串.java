package xiaoyu.algo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 上升下降字符串 {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        while (sb.length() < s.length()) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] > 0) {
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
        }
        return sb.toString();
    }
}
