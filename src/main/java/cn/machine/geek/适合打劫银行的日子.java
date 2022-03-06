package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;

public class 适合打劫银行的日子 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> result = new LinkedList<>();
        int n = security.length;
        if (time > n) {
            return result;
        }
        // 小于或等于前面的数字
        int[] left = new int[n];
        // 大于或等于前面的数字
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (left[i] >= time && right[i] >= time) {
                result.add(i);
            }
        }
        return result;
    }
}
