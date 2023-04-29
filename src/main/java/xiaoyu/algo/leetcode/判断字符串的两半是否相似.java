package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 判断字符串的两半是否相似 {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int l = 0, r = s.length() - 1;
        int lc = 0, rc = 0;
        while (l < r) {
            if (set.contains(Character.toLowerCase(s.charAt(l)))) {
                lc++;
            }
            if (set.contains(Character.toLowerCase(s.charAt(r)))) {
                rc++;
            }
            l++;
            r--;
        }
        return lc == rc;
    }
}