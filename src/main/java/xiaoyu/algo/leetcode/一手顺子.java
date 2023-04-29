package xiaoyu.algo.leetcode;

import java.util.*;

public class 一手顺子 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (groupSize > n || n % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
            heap.add(hand[i]);
        }
        while (!heap.isEmpty()) {
            Integer cur = heap.poll();
            if (cur == null || map.getOrDefault(cur, 0) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                Integer num = map.getOrDefault(cur + i, 0);
                if (num <= 0) {
                    return false;
                }
                map.put(cur + i, num - 1);
            }
        }
        return true;
    }
}
