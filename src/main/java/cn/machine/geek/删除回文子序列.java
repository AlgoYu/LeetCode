package cn.machine.geek;

public class 删除回文子序列 {
    public int removePalindromeSub(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return 2;
            }
        }
        return 1;
    }
}
