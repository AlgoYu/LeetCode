package xiaoyu.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 将数组和减半的最少操作次数 {
    public int halveArray(int[] nums) {
        double sum = 0D;
        Queue<Double> queue = new PriorityQueue<>(nums.length, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });
        for (int num : nums) {
            sum += num;
            queue.offer((double) num);
        }
        double half = sum / 2D;
        double total = 0D;
        int num = 0;
        while (total < half && !queue.isEmpty()) {
            Double poll = queue.poll();
            double v = poll / 2D;
            queue.offer(v);
            total += v;
            num++;
        }
        return num;
    }
}
