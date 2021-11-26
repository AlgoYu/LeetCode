package cn.machine.geek;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class 随机翻转矩阵 {
    Set<String> set;
    Random random;
    int m;
    int n;

    public 随机翻转矩阵(int m, int n) {
        this.m = m;
        this.n = n;
        set = new HashSet<>();
        random = new Random();
    }

    public int[] flip() {
        int tm = 0;
        int tn = 0;
        do {
            tm = random.nextInt(m);
            tn = random.nextInt(n);
        } while (set.contains(tm + "-" + tn));

        set.add(tm + "-" + tn);
        return new int[]{tm, tn};
    }

    public void reset() {
        set.clear();
    }
}
