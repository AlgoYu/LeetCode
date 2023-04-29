package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 游戏中弱角色的数量 {
    public int numberOfWeakCharacters(int[][] properties) {
        if (properties.length < 2) {
            return 0;
        }
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int count = 0;
        int maxDefense = properties[0][1];
        for (int[] pro : properties) {
            if (pro[1] < maxDefense) {
                count++;
            } else {
                maxDefense = pro[1];
            }
        }
        return count;
    }
}
