package xiaoyu.algo.leetcode;

public class 盒子中小球的最大数量 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxs = new int[46];
        while (lowLimit <= highLimit) {
            int cur = lowLimit;
            int value = 0;
            while (cur > 0) {
                value += cur % 10;
                cur /= 10;
            }
            boxs[value]++;
            lowLimit++;
        }
        int max = 0;
        for (int i = 0; i < boxs.length; i++) {
            max = Math.max(boxs[i], max);
        }
        return max;
    }
}