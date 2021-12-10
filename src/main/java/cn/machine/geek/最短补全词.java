package cn.machine.geek;

public class 最短补全词 {
    public static void main(String[] args) {
        最短补全词 test = new 最短补全词();
        test.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = countWord(licensePlate);
        sort(words);
        for (int index = 0; index < words.length; index++) {
            int[] ints = countWord(words[index]);
            boolean flag = true;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0 && count[i] > ints[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return words[index];
            }
            index++;
        }
        return null;
    }

    private void sort(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String tmp = words[i];
            int j = i - 1;
            while (j >= 0) {
                if (words[j].length() <= tmp.length()) {
                    break;
                }
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = tmp;
        }
    }

    private int[] countWord(String str) {
        int[] word = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                word[(ch - 'a')]++;
            }
            if (ch >= 'A' && ch <= 'Z') {
                word[ch - 'A']++;
            }
        }
        return word;
    }
}
