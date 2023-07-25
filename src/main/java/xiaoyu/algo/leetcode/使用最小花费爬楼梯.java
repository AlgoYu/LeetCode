package xiaoyu.algo.leetcode;

public class 使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        int p1 = cost[0], p2 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int min = Math.min(p1, p2) + cost[i];
            p1 = p2;
            p2 = min;
        }
        return Math.min(p1, p2);
    }
}
