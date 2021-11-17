package cn.machine.geek;

import java.util.*;

public class 最大单词长度乘积 {
    public int maxProduct(String[] words) {
        Arrays.sort(words);
        int n = words.length;
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            Set<Character> set = getSet(words[i]);
            int il = words[i].length();
            X:
            for (int j = i - 1; j >= 0; j--) {
                if (il * words[j].length() <= max) {
                    continue;
                }
                for (int k = 0; k < words[j].length(); k++) {
                    if (set.contains(words[j].charAt(k))) {
                        continue X;
                    }
                }
                max = Math.max(max, il * words[j].length());
            }
        }
        return Math.max(max, 0);
    }

    private Set<Character> getSet(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        return set;
    }
}
