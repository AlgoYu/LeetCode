package xiaoyu.algo.leetcode;

import java.util.*;

public class 相对名次 {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2.compareTo(o1);
        });
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
            queue.add(score[i]);
        }
        String[] strings = new String[score.length];
        if (!queue.isEmpty()) {
            strings[map.get(queue.poll())] = "Gold Medal";
        }
        if (!queue.isEmpty()) {
            strings[map.get(queue.poll())] = "Silver Medal";
        }
        if (!queue.isEmpty()) {
            strings[map.get(queue.poll())] = "Bronze Medal";
        }
        int n = 4;
        while (!queue.isEmpty()) {
            strings[map.get(queue.poll())] = String.valueOf(n++);
        }
        return strings;
    }
}
