package xiaoyu.algo.leetcode;

import java.util.*;

public class 距离相等的条形码 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result = new int[barcodes.length];
        for (int i = 0; i < result.length; i++) {
            int[] poll1 = heap.poll();
            if (result[i] == 0 && result[Math.max(i - 1, 0)] != poll1[0]) {
                result[i] = poll1[0];
                if (poll1[1] > 1) {
                    poll1[1]--;
                    heap.offer(poll1);
                }
            } else {
                int[] poll2 = heap.poll();
                result[i] = poll2[0];
                if (poll2[1] > 1) {
                    poll2[1]--;
                    heap.offer(poll2);
                }
                heap.offer(poll1);
            }
        }
        return result;
    }
}
