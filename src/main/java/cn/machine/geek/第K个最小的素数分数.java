package cn.machine.geek;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 第K个最小的素数分数 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value.compareTo(o1.value);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Node node = new Node();
                node.value = (float) arr[i] / (float) arr[j];
                node.arr = new int[]{arr[i], arr[j]};
                if (queue.size() < k) {
                    queue.add(node);
                    continue;
                }
                if (queue.peek().value.compareTo(node.value) < 0) {
                    continue;
                }
                queue.poll();
                queue.add(node);
            }
        }
        return queue.poll().arr;
    }

    class Node {
        Float value;
        int[] arr;
    }
}
