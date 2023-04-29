package xiaoyu.algo.leetcode;

public class 提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0 || timeSeries[i] - timeSeries[i - 1] >= duration) {
                count += duration;
            } else {
                count = count + (timeSeries[i] - timeSeries[i - 1]);
            }
        }
        return count;
    }
}
