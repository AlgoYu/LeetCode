package cn.machine.geek;

public class 完美数 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int count = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                count += i;
            }
        }
        return count == num;
    }
}
