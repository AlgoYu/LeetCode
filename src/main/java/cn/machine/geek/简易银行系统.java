package cn.machine.geek;

public class 简易银行系统 {
    long[] balance;

    public 简易银行系统(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!check(account1) || !check(account2)) {
            return false;
        }
        if (money > balance[account1 - 1]) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!check(account)) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!check(account) || money > balance[account - 1]) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }

    private boolean check(int account) {
        return account - 1 >= 0 && account - 1 <= balance.length;
    }
}
