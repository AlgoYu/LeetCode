package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 查找包含给定字符的单词 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) {
                result.add(i);
            }
        }
        return result;
    }
}
