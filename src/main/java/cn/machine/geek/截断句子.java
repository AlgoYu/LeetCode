package cn.machine.geek;

public class 截断句子 {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int index = 0;
        int word = 0;
        while (word < k && index < n) {
            if (s.charAt(index) == ' ') {
                word++;
            }
            index++;
        }
        return n == index ? s.substring(0, n) : s.substring(0, index - 1);
    }
}
