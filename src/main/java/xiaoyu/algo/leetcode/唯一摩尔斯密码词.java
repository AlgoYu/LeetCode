package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 唯一摩尔斯密码词 {
    private static final String[] INDEX = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(INDEX[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
