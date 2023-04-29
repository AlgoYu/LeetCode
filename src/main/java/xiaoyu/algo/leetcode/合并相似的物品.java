package xiaoyu.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class 合并相似的物品 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            List<Integer> ints = map.get(items1[i][0]);
            if (ints == null) {
                ints = Arrays.asList(items1[i][0], 0);
                map.put(items1[i][0], ints);
            }
            ints.set(1, ints.get(1) + items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            List<Integer> ints = map.get(items2[i][0]);
            if (ints == null) {
                ints = Arrays.asList(items2[i][0], 0);
                map.put(items2[i][0], ints);
            }
            ints.set(1, ints.get(1) + items2[i][1]);
        }
        return map.values().stream().sorted((o1, o2) -> {
            return o1.get(0) - o2.get(0);
        }).collect(Collectors.toList());
    }
}
