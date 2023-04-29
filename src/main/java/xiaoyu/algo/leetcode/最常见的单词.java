package xiaoyu.algo.leetcode;

import java.util.*;

public class 最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.isEmpty()) {
            return paragraph;
        }
        Map<String, Integer> count = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        char[] chars = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        String maxWord = "";
        int maxNum = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isLetter(ch)) {
                sb.append(ch);
                continue;
            }
            if (sb.length() > 0) {
                String word = sb.toString().toLowerCase();
                sb.delete(0, sb.length());
                if (!set.contains(word)) {
                    int num = count.getOrDefault(word, 0) + 1;
                    count.put(word, num);
                    if (num > maxNum) {
                        maxNum = num;
                        maxWord = word;
                    }
                }
            }
        }
        if (sb.length() > 0) {
            String word = sb.toString().toLowerCase();
            sb.delete(0, sb.length());
            if (!set.contains(word)) {
                int num = count.getOrDefault(word, 0) + 1;
                count.put(word, num);
                if (num > maxNum) {
                    maxWord = word;
                }
            }
        }
        return maxWord;
    }
}
