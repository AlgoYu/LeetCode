package cn.machine.geek;

public class 反转单词前缀 {
    public String reversePrefix(String word, char ch) {
        int right = word.indexOf(ch);
        if (right == -1) {
            return word;
        }
        int left = 0;
        if (left == right) {
            return word;
        }
        char[] chars = word.toCharArray();
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return new String(chars);
    }
}
