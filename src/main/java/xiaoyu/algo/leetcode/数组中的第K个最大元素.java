package xiaoyu.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.size() == k && num > queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        return !queue.isEmpty() ? queue.poll() : 0;
    }
}
