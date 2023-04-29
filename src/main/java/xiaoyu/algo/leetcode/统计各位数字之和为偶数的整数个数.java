package xiaoyu.algo.leetcode;

public class 统计各位数字之和为偶数的整数个数 {
    public static void main(String[] args) {
        统计各位数字之和为偶数的整数个数 test = new 统计各位数字之和为偶数的整数个数();
        test.countEven(30);
    }

    public int countEven(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            int n = 0;
            int tmp = i;
            while (tmp > 0) {
                n += tmp % 10;
                tmp /= 10;
            }
            if ((n & 1) == 0) {
                result++;
            }
        }
        return result;
    }
}
