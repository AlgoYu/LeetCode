package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < list.get(i)[0]) {
                result.add(list.get(i));
            } else {
                int[] last = result.get(result.size() - 1);
                int[] cur = list.get(i);
                last[0] = Math.min(last[0], cur[0]);
                last[1] = Math.max(last[1], cur[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
