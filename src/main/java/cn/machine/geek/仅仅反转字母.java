package cn.machine.geek;

public class 仅仅反转字母 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !isLetter(chars[l])) {
                l++;
            }
            while (l < r && !isLetter(chars[r])) {
                r--;
            }
            if (l == r) {
                break;
            }
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
