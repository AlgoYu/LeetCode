package cn.machine.geek;

public class 判断一个数字是否可以表示成三的幂的和 {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            int num = n % 3;
            if (num != 0 && num != 1) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}