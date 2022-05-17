package cn.machine.geek;

public class 验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i], words[i - 1], orders) < 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String a, String b, int[] order) {
        int min = Math.min(a.length(), b.length());
        for (int i = 0; i < min; i++) {
            int com = order[a.charAt(i) - 'a'] - order[b.charAt(i) - 'a'];
            if (com != 0) {
                return com;
            }
        }
        return a.length() - b.length();
    }
}
