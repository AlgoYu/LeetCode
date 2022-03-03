package cn.machine.geek;

public class 各位相加 {
    private static final int N = 10;

    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num > 0) {
                temp = temp + num % N;
                num /= N;
            }
            num = temp;
        }
        return num;
    }
}
