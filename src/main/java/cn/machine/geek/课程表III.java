package cn.machine.geek;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 课程表III {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int curDays = 0;
        int count = 0;
        for (int i = 0; i < courses.length; i++) {
            int ti = courses[i][0];
            int li = courses[i][1];
            if (ti + curDays <= li) {
                queue.offer(ti);
                curDays += ti;
            } else if (!queue.isEmpty() && queue.peek() > ti) {
                curDays -= queue.poll() - ti;
                queue.offer(ti);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        课程表III test = new 课程表III();
        test.scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}});
    }
}
