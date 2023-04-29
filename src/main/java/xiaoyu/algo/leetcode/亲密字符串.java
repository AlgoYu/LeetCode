package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 亲密字符串 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
            return false;
        }
        int indexA = -1;
        int indexB = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == goal.charAt(i)) {
                continue;
            }
            if (indexA == -1) {
                indexA = i;
            } else if (indexB == -1) {
                indexB = i;
            } else {
                return false;
            }
        }
        return indexA != -1 && indexB != -1 && s.charAt(indexA) == goal.charAt(indexB) && s.charAt(indexB) == goal.charAt(indexA);
    }
}
