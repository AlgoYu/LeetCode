package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int index = 0;
        while (index < intervals.length) {
            int[] temp = new int[2];
            temp[0] = intervals[index][0];
            temp[1] = intervals[index][1];
            if (list.isEmpty() || temp[0] > list.get(list.size() - 1)[1]) {
                list.add(temp);
            } else {
                list.get(list.size() - 1)[1] = Math.max(temp[1], list.get(list.size() - 1)[1]);
            }
            index++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
