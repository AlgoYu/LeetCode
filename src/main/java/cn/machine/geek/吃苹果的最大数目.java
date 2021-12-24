package cn.machine.geek;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 吃苹果的最大数目 {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int curDay = 0;
        int countApple = 0;
        // N天内
        while (curDay < n) {
            // 找出过期的或吃完的淘汰掉
            while (!queue.isEmpty() && (queue.peek()[0] <= curDay || queue.peek()[1] == 0)) {
                queue.poll();
            }
            // 加入今天的
            if (apples[curDay] > 0) {
                queue.add(new int[]{days[curDay] + curDay, apples[curDay]});
            }
            // 吃掉一个
            if (!queue.isEmpty()) {
                int[] peek = queue.peek();
                if (peek[1] > 0) {
                    countApple++;
                    peek[1]--;
                }
            }
            curDay++;
        }
        // N天过去
        while (!queue.isEmpty()) {
            // 找出过期的淘汰掉
            while (!queue.isEmpty() && (queue.peek()[0] <= curDay || queue.peek()[1] == 0)) {
                queue.poll();
            }
            // 为空
            if (queue.isEmpty()) {
                break;
            }
            // 吃掉一个
            int[] peek = queue.peek();
            countApple++;
            peek[1]--;
            curDay++;
        }
        return countApple;
    }
}
