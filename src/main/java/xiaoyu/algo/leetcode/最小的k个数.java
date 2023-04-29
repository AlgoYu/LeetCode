package xiaoyu.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] min = new int[k];
        Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < n; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
                continue;
            }
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            min[i] = queue.poll();
        }
        return min;
    }
}
