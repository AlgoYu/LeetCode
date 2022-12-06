package cn.machine.geek;

import java.util.HashSet;
import java.util.Set;

public class 字符串中不同整数的数目 {
    public int numDifferentIntegers(String word) {
        int index = 0;
        Set<String> set = new HashSet<>();
        while (index < word.length()) {
            if (Character.isDigit(word.charAt(index))) {
                while (index < word.length() && Character.isDigit(word.charAt(index)) && word.charAt(index) == '0') {
                    index++;
                }
                int start = index;
                while (index < word.length() && Character.isDigit(word.charAt(index))) {
                    index++;
                }
                set.add(word.substring(start, index));
            }
            index++;
        }
        return set.size();
    }
}