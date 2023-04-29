package xiaoyu.algo.leetcode;

public class 判断一个数的数字计数是否等于数位的值 {
    public boolean digitCount(String num) {
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (n != count[i]) {
                return false;
            }
        }
        return true;
    }
}
