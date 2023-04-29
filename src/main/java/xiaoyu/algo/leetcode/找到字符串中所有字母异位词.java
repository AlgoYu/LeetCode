package xiaoyu.algo.leetcode;

import java.util.*;

public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (n == 0 || m == 0 || n < m) {
            return list;
        }
        int[] sWord = new int[26];
        int[] pWord = new int[26];
        for (int i = 0; i < m; i++) {
            sWord[s.charAt(i) - 'a']++;
            pWord[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sWord, pWord)) {
            list.add(0);
        }
        for (int i = 0; i < n - m; i++) {
            sWord[s.charAt(i) - 'a']--;
            sWord[s.charAt(i + m) - 'a']++;
            if (Arrays.equals(sWord, pWord)) {
                list.add(i);
            }
        }
        return list;
    }
}
