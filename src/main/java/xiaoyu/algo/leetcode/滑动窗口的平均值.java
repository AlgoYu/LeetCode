package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口的平均值 {
    int size;
    Queue<Integer> queue;
    double count;

    public 滑动窗口的平均值(int size) {
        this.size = size;
        queue = new LinkedList<>();
        count = 0;
    }

    public double next(int val) {
        count += val;
        queue.offer(val);
        if (queue.size() > size && !queue.isEmpty()) {
            count -= queue.poll();
        }
        return count / queue.size();
    }
}
