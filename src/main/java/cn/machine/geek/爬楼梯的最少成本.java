package cn.machine.geek;

public class 爬楼梯的最少成本 {
    public int minCostClimbingStairs(int[] cost) {
        int p2 = cost[0], p1 = cost[1];
        int tmp;
        for (int i = 2; i < cost.length; i++) {
            tmp = Math.min(p1, p2) + cost[i];
            p2 = p1;
            p1 = tmp;
        }
        return Math.min(p1, p2);
    }
}