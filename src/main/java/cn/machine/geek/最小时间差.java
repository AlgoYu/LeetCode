package cn.machine.geek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最小时间差 {
    private final int HOUR_MINUTE = 60;
    private final int MAX = HOUR_MINUTE * 24;

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Integer> list = new ArrayList<>(n);
        for (String s : timePoints) {
            String[] split = s.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            list.add(hour * HOUR_MINUTE + minute);
        }
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int time = list.get(i) - list.get(i - 1);
            min = Math.min(min, time);
        }
        min = Math.min(MAX - list.get(n - 1) + list.get(0), min);
        return min;
    }
}
