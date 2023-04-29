package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 最接近目标价格的甜点成本 {
    public static void main(String[] args) {
        最接近目标价格的甜点成本 test = new 最接近目标价格的甜点成本();
        test.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18);
    }

    int[] toppingCosts;
    int target;
    int cost;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.toppingCosts = toppingCosts;
        this.target = target;
        cost = Arrays.stream(baseCosts).min().getAsInt();
        for (int i = 0; i < baseCosts.length; i++) {
            choose(baseCosts[i], 0);
        }
        return cost;
    }

    private void choose(int baseCost, int index) {
        if (baseCost - target > Math.abs(cost - target) || index == toppingCosts.length) {
            if (Math.abs(baseCost - target) <= Math.abs(cost - target)) {
                if (Math.abs(baseCost - target) < Math.abs(cost - target)) {
                    cost = baseCost;
                } else {
                    cost = Math.min(cost, baseCost);
                }
            }
            return;
        }
        choose(baseCost, index + 1);
        choose(baseCost + toppingCosts[index], index + 1);
        choose(baseCost + (toppingCosts[index] * 2), index + 1);
    }
}