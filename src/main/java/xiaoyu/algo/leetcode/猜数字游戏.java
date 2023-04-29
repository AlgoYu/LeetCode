package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 猜数字游戏 {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        Map<Character, Integer> map = new HashMap<>();
        int m = 0;
        for (int i = 0; i < n; i++) {
            char ch = secret.charAt(i);
            if (ch == guess.charAt(i)) {
                m++;
            } else {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            char ch = guess.charAt(i);
            if (secret.charAt(i) != ch) {
                Integer num = map.getOrDefault(ch, 0);
                if (num > 0) {
                    k++;
                    map.put(ch, num - 1);
                }
            }
        }
        return m + "A" + k + "B";
    }
}
