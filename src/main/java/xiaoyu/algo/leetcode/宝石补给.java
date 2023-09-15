package xiaoyu.algo.leetcode;

public class 宝石补给 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            int num = gem[op[0]] / 2;
            gem[op[0]] -= num;
            gem[op[1]] += num;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int g : gem) {
            max = Math.max(max, g);
            min = Math.min(min, g);
        }
        return max - min;
    }
}
