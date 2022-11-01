package cn.machine.geek;

public class 检查两个字符串数组是否相等 {
    public static void main(String[] args) {
        检查两个字符串数组是否相等 test = new 检查两个字符串数组是否相等();
        test.arrayStringsAreEqual(
            new String[]{"abc", "d", "defg"},
            new String[]{"abcddef"});
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, i1c = 0;
        int i2 = 0, i2c = 0;
        while (i1 < word1.length || i2 < word2.length) {
            if (word1[i1].charAt(i1c) != word2[i2].charAt(i2c)) {
                return false;
            }
            i1c = (i1c + 1) % word1[i1].length();
            if (i1c == 0) {
                i1++;
                i1c = 0;
            }
            i2c = (i2c + 1) % word2[i2].length();
            if (i2c == 0) {
                i2++;
                i2c = 0;
            }
            if ((i1 >= word1.length && i2 < word2.length) || (i2 >= word2.length && i1 < word1.length)) {
                return false;
            }
        }
        return true;
    }
}