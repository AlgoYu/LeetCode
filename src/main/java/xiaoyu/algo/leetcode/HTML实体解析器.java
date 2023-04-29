package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HTML实体解析器 {
    Map<String, String> map = new HashMap<String, String>() {
        {
            put("&quot;", "\"");
            put("&apos;", "'");
            put("&amp;", "&");
            put("&gt;", ">");
            put("&lt;", "<");
            put("&frasl;", "/");
        }
    };

    public String entityParser(String text) {
        int n = text.length();
        if (n < 4) {
            return text;
        }
        char[] chars = text.toCharArray();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            sb.append(chars[index]);
            if (chars[index] == ';') {
                int k = Math.max(index - 7, 0);
                String sign = map.get(text.substring(k, index + 1));
                while (k < index && sign == null) {
                    k++;
                    sign = map.get(text.substring(k, index + 1));
                }
                if (sign != null) {
                    sb.delete(sb.lastIndexOf("&"), sb.length());
                    sb.append(sign);
                }
            }
            index++;
        }
        return sb.toString();
    }
}
