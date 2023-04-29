package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 统计一致字符串的数目 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int size = 0;
        X:
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!set.contains(words[i].charAt(j))) {
                    continue X;
                }
            }
            size++;
        }
        return size;
    }
}