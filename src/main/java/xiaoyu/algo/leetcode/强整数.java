package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 强整数 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                int v = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (v > bound) {
                    break;
                }
                set.add(v);
            }
        }
        return new ArrayList<>(set);
    }
}