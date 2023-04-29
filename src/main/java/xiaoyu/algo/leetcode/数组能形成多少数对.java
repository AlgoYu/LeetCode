package xiaoyu.algo.leetcode;

public class 数组能形成多少数对 {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] res = new int[2];
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                res[0] = res[0] + count[i] / 2;
            }
        }
        res[1] = nums.length - res[0] * 2;
        return res;
    }
}
