package xiaoyu.algo.leetcode;

public class 第一个出现两次的字母 {
    public char repeatedCharacter(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (chars[i] >= 1) {
                return c;
            }
            chars[i]++;
        }
        return 'a';
    }
}
