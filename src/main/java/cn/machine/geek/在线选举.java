package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 在线选举 {
    int[] persons;
    int[] times;
    int[] result;

    public 在线选举(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        result = new int[times.length];
        int max = 0;
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            Integer n = map.getOrDefault(persons[i], 0);
            n++;
            map.put(persons[i], n);
            if (n >= max) {
                num = persons[i];
                max = n;
            }
            result[i] = num;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = result.length;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (times[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result[left - 1];
    }
}
