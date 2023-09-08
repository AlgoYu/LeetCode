package xiaoyu.algo.leetcode;

public class 计算列车到站时间 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
