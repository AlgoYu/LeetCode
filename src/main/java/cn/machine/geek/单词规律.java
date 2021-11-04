package cn.machine.geek;

import java.util.*;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/4 12:38 下午
 * @Email 794763733@qq.com
 */
public class 单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        int m = words.length;
        if (n != m) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Character ch = pattern.charAt(i);
            String word = words[i];

            String tempStr = map.get(ch);
            if (tempStr == null && !set.contains(word)) {
                map.put(ch, word);
                set.add(word);
            } else if (!Objects.equals(tempStr, word)) {
                return false;
            }
            map.put(pattern.charAt(i), words[i]);
        }
        return true;
    }
}
