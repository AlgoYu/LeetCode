package xiaoyu.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两个相同字符之间的最长子字符串 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (map[cur] == -1) {
                map[cur] = i;
                continue;
            }
            max = Math.max(max, i - map[cur] - 1);
        }
        return max;
    }
}
