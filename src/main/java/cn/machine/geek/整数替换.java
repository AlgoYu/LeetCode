package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 整数替换 {
    Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        Integer result = map.get(n);
        if (result != null) {
            return result;
        }
        if ((n & 1) == 0) {
            result = integerReplacement(n / 2) + 1;
            map.put(n, result);
            return result;
        }
        result = Math.min(integerReplacement(n /2 ), integerReplacement(n / 2 + 1)) + 2;
        map.put(n, result);
        return result;
    }
}
