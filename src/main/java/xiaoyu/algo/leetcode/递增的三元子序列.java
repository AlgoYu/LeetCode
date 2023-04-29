package xiaoyu.algo.leetcode;

public class 递增的三元子序列 {
    public static void main(String[] args) {
        递增的三元子序列 test = new 递增的三元子序列();
        test.increasingTriplet(new int[]{0, 4, 2, 1, 0, -1, -3});
    }

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i];
            if (tmp > second) {
                return true;
            }
            if (tmp > first) {
                second = tmp;
            } else {
                first = tmp;
            }
        }
        return false;
    }
}
