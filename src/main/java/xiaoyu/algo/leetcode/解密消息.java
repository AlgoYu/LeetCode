package xiaoyu.algo.leetcode;

import java.util.*;

public class 解密消息 {
    public String decodeMessage(String key, String message) {
        char[] table = new char[26];
        Set<Character> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (Character.isLowerCase(c) && !set.contains(c)) {
                set.add(c);
                table[c - 'a'] = (char) ('a' + index);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.append(table[c - 'a']);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
