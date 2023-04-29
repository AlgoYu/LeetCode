package xiaoyu.algo.leetcode;

import java.util.*;

public class 两句话中的不常见单词 {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new LinkedList<>();
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String w : s1Words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (String w : s2Words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
