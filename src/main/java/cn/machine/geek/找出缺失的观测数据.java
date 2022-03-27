package cn.machine.geek;

public class 找出缺失的观测数据 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int len = n + m;
        int total = len * mean;
        int cur = 0;
        for (int roll : rolls) {
            cur += roll;
        }
        int other = total - cur;
        if (other < n || other > n * 6) {
            return new int[0];
        }
        int[] lose = new int[n];
        int avg = other / n;
        int yu = other % n;
        for (int i = 0; i < n; i++) {
            lose[i] = avg + (i < yu ? 1 : 0);
        }
        return lose;
    }
}
