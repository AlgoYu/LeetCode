package xiaoyu.algo.leetcode;

public class 检查句子中的数字是否递增 {
    public boolean areNumbersAscending(String s) {
        char[] chars = s.toCharArray();
        int pre = 0;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + (chars[i] - '0');
                i++;
            }
            if (num != 0) {
                if (num > pre) {
                    pre = num;
                    num = 0;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
