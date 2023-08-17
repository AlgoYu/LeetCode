package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            while (l < r && set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            max = Math.max(max, set.size());
            r++;
        }
        return max;
    }
}
