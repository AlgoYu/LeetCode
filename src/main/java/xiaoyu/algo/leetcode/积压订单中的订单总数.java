package xiaoyu.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class 积压订单中的订单总数 {
    public static void main(String[] args) {
        积压订单中的订单总数 test = new 积压订单中的订单总数();
        test.getNumberOfBacklogOrders(new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}});
    }

    private final int N = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> purchases = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });
        Queue<int[]> sells = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sells.isEmpty() && order[1] > 0 && order[0] >= sells.peek()[0]) {
                    if (order[1] >= sells.peek()[1]) {
                        order[1] -= sells.poll()[1];
                    } else {
                        sells.peek()[1] -= order[1];
                        order[1] = 0;
                        break;
                    }
                }
                if (order[1] > 0) {
                    purchases.offer(order);
                }
            } else {
                while (!purchases.isEmpty() && order[1] > 0 && order[0] <= purchases.peek()[0]) {
                    if (order[1] >= purchases.peek()[1]) {
                        order[1] -= purchases.poll()[1];
                    } else {
                        purchases.peek()[1] -= order[1];
                        order[1] = 0;
                        break;
                    }
                }
                if (order[1] > 0) {
                    sells.offer(order);
                }
            }
        }
        return (count(purchases) + count(sells)) % N;
    }

    private int count(Queue<int[]> queue) {
        int result = 0;
        for (int[] order : queue) {
            result += order[1];
            result %= N;
        }
        return result;
    }
}
