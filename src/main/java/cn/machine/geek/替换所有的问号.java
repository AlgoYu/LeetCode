package cn.machine.geek;

import java.util.Random;

public class 替换所有的问号 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (chars[i] == '?') {
                ch = 'a';
                char pre = i == 0 ? 'a' : chars[i - 1];
                char next = i == n - 1 ? 'a' : chars[i + 1];
                while (ch == pre || ch == next) {
                    ch = (char) ('a' + random.nextInt(26));
                }
                chars[i] = ch;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
