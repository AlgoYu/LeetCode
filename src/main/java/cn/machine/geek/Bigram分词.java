package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Bigram分词 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new LinkedList<>();
        String[] s = text.split(" ");
        int n = s.length;
        for (int i = 2; i < n; i++) {
            if (Objects.equals(s[i - 2], first) && Objects.equals(s[i - 1], second)) {
                list.add(s[i]);
            }
        }
        String[] strings = list.toArray(new String[list.size()]);
        return strings;
    }
}
