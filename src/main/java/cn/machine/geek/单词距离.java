package cn.machine.geek;

public class 单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        int w1 = -100000;
        int w2 = -100000;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                min = Math.min(i - w2, min);
                w1 = i;
            }
            if (word.equals(word2)) {
                min = Math.min(i - w1, min);
                w2 = i;
            }
        }
        return min;
    }
}
