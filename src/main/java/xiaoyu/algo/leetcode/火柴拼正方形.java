package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 火柴拼正方形 {
    private int length;
    private int[] edges;

    public boolean makesquare(int[] matchsticks) {
        int count = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            count += matchsticks[i];
        }
        if (count % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        length = count / 4;
        edges = new int[4];
        return backtrack(matchsticks, matchsticks.length - 1);
    }

    private boolean backtrack(int[] matchsticks, int index) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + matchsticks[index] > length) {
                continue;
            }
            edges[i] += matchsticks[index];
            if (backtrack(matchsticks, index - 1)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
