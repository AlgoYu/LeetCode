package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;

public class 和为K的最少斐波那契数字数目 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new LinkedList<>();
        int num = 0;
        list.add(1);
        list.add(1);
        while (num < k) {
            num = list.get(list.size() - 1) + list.get(list.size() - 2);
            list.add(num);
        }
        int count = 0;
        int total = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int cur = list.get(i);
            if (total + cur < k) {
                total += cur;
                count++;
                continue;
            }
            if (total + cur == k) {
                return count + 1;
            }
        }
        return count;
    }
}
