package cn.machine.geek;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 至少是其他数字两倍的最大数 {
    private final int M = 51;

    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i] * M + i);
        }
        Integer max = queue.poll();
        Integer second = queue.poll();
        if (max / M >= (second / M * 2)) {
            return max % M;
        }
        return -1;
    }
}
