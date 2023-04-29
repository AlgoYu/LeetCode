package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            count1.put(c1, count1.getOrDefault(c1, 0) + 1);
            count2.put(c2, count2.getOrDefault(c2, 0) + 1);
        }
        if (count1.size() != count2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
            if (!Objects.equals(entry.getValue(), count2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
