package cn.machine.geek;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/6 5:18 下午
 * @Email 794763733@qq.com
 */
public class 最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.isEmpty() || priorityQueue.size() < k) {
                priorityQueue.add(arr[i]);
                continue;
            }
            if (arr[i] > priorityQueue.peek()) {
                continue;
            }
            if (priorityQueue.size() + 1 > k) {
                priorityQueue.remove();
            }
            priorityQueue.add(arr[i]);
        }
        int[] result = new int[priorityQueue.size()];
        int index = priorityQueue.size() - 1;
        while (!priorityQueue.isEmpty()) {
            result[index--] = priorityQueue.poll();
        }
        return result;
    }
}
