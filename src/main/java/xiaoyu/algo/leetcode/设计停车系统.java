package xiaoyu.algo.leetcode;

public class 设计停车系统 {
    int[] capacity;

    public 设计停车系统(int big, int medium, int small) {
        capacity = new int[3];
        capacity[0] = big;
        capacity[1] = medium;
        capacity[2] = small;
    }

    public boolean addCar(int carType) {
        if (capacity[carType - 1] == 0) {
            return false;
        }
        capacity[carType - 1]--;
        return true;
    }
}
