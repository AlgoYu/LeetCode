package xiaoyu.algo.leetcode;

public class 构成特定和需要添加的最少元素 {
    public int minElements(int[] nums, int limit, int goal) {
        long cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
        }
        long abs = Math.abs(cur - goal);
        if (abs == 0) {
            return 0;
        }
        if (abs < limit) {
            return 1;
        }
        int i = (int) (abs / limit);
        return abs % limit > 0 ? i + 1 : i;
    }
}