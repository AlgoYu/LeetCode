package cn.machine.geek;

public class 最大重复子字符串 {
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int j = i;
            int k = 0;
            int continuous = 0;
            while (j < sequence.length()) {
                if (sequence.charAt(j) != word.charAt(k)) {
                    break;
                }
                j++;
                k++;
                if (k == word.length()) {
                    k = 0;
                    continuous++;
                }
            }
            max = Math.max(max, continuous);
        }
        return max;
    }
}