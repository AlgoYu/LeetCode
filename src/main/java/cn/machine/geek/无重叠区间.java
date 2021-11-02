package cn.machine.geek;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/1 3:01 下午
 * @Email 794763733@qq.com
 */
public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int bounds = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= bounds) {
                count++;
                bounds = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
