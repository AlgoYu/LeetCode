package cn.machine.geek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 按身高排序 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] result = new String[heights.length];
        int n = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[n++] = map.get(heights[i]);
        }
        return result;
    }
}
