package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 可以形成最大正方形的矩形数目 {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] square : rectangles) {
            int s = Math.min(square[0], square[1]);
            max = Math.max(s, max);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.getOrDefault(max, 0);
    }
}
