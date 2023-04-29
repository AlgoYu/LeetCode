package xiaoyu.algo.leetcode;

public class 二进制表示中质数个计算置位 {
    public int countPrimeSetBits(int left, int right) {
        int total = 0;
        while (left <= right) {
            if (isValid(getBinaryOne(left))) {
                total++;
            }
            left++;
        }
        return total;
    }

    private int getBinaryOne(int num) {
        int total = 0;
        while (num > 0) {
            int c = num % 2;
            if (c == 1) {
                total++;
            }
            num /= 2;
        }
        return total;
    }

    private boolean isValid(int num) {
        if (num < 2) {
            return false;
        }
        int n = 2;
        int max = num / 2;
        while (n <= max) {
            if (num % n == 0) {
                return false;
            }
            n++;
        }
        return true;
    }
}
