package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 移动石子直到连续 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = {a, b, c};
        Arrays.sort(stones);
        int d1 = stones[1] - stones[0];
        int d2 = stones[2] - stones[1];
        if (d1 == 1 && d2 == 1) {   // 已经排好序，只需要判断 d1 和 d2 是否为 1
            return new int[]{0, 0};
        }
        int maxDist = stones[2] - stones[0] - 2;
        if (d1 <= 2 || d2 <= 2) {   // 至少有一个相邻的
            return new int[]{1, maxDist};
        }
        return new int[]{2, maxDist};
    }
}
