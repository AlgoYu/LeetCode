package cn.machine.geek;

import java.util.*;

public class 最简分数 {
    public List<String> simplifiedFractions(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                set.add(simple(j, i));
            }
        }
        List<String> result = new ArrayList<>(set.size());
        result.addAll(set);
        return result;
    }

    private String simple(int a, int b) {
        int gcd = getGCD(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }

    private int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
