package cn.machine.geek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 替换字符串中的括号内容 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> strings = knowledge.get(i);
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int r = i + 1;
                while (r < s.length() && s.charAt(r) != ')') {
                    r++;
                }
                String substring = s.substring(i + 1, r);
                sb.append(map.getOrDefault(substring, "?"));
                i = r;
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
