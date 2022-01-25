package cn.machine.geek;

public class 比赛中的配对次数 {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            int p = n / 2;
            count += p;
            n = (n % 2) + p;
        }
        return count;
    }
}
