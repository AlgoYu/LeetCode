package cn.machine.geek;

public class 统计包含给定前缀的字符串 {
    public static void main(String[] args) {
        统计包含给定前缀的字符串 test = new 统计包含给定前缀的字符串();
        test.prefixCount(new String[]{"word,", "haha"}, "w");
    }

    public int prefixCount(String[] words, String pref) {
        int[] wi = new int[words.length];
        int n = pref.length();
        int result = 0;
        for (int i = 0; i < pref.length(); i++) {
            char pre = pref.charAt(i);
            for (int j = 0; j < words.length; j++) {
                int index = wi[j];
                if (index == i && index < words[j].length() && words[j].charAt(index) == pre) {
                    wi[j]++;
                    if (wi[j] == n) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
