package cn.machine.geek;

import java.util.*;

public class 股票价格波动 {
    Queue<int[]> max;
    Queue<int[]> min;
    int current;
    Map<Integer, Integer> map;

    public 股票价格波动() {
        max = new PriorityQueue<int[]>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        min = new PriorityQueue<int[]>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        map = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        current = Math.max(timestamp, current);
        int[] time = new int[]{timestamp, price};
        max.offer(time);
        min.offer(time);
    }

    public int current() {
        return map.get(current);
    }

    public int maximum() {
        for (; ; ) {
            int[] peek = max.peek();
            if (map.get(peek[0]) == peek[1]) {
                return peek[1];
            }
            max.poll();
        }
    }

    public int minimum() {
        for (; ; ) {
            int[] peek = min.peek();
            if (map.get(peek[0]) == peek[1]) {
                return peek[1];
            }
            min.poll();
        }
    }
}
