package xiaoyu.algo.leetcode;

public class 水果成篮II {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = 0;
        boolean[] use = new boolean[baskets.length];
        X:
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruits[i] && !use[j]) {
                    use[j] = true;
                    continue X;
                }
            }
            n++;
        }
        return n;
    }
}
