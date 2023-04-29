package xiaoyu.algo.leetcode;

import java.util.Map;

public class 重排字符形成目标字符串 {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int num = 0;
        X:
        while (true) {
            for (int i = 0; i < target.length(); i++) {
                int index = target.charAt(i) - 'a';
                count[index]--;
                if (count[index] < 0) {
                    break X;
                }
            }
            num++;
        }
        return num;
    }
}
