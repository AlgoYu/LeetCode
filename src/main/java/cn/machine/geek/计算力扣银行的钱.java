package cn.machine.geek;

public class 计算力扣银行的钱 {
    private final int WEEK = 7;

    public int totalMoney(int n) {
        if (n == 1) {
            return n;
        }
        int k = 0;
        int money = 1;
        int day = 1;
        int count = 0;
        while (day <= n) {
            count += money;
            day++;
            money++;
            if (day % WEEK == 1) {
                k++;
                money = 1 + k;
            }
        }
        return count;
    }
}
