package xiaoyu.algo.leetcode;

public class 将数字变成0的操作次数 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num /= 2;
            }
            count++;
        }
        return count;
    }
}
