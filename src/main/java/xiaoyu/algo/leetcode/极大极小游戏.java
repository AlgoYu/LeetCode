package xiaoyu.algo.leetcode;

public class 极大极小游戏 {
    public int minMaxGame(int[] nums) {
        while (!(nums.length == 1)) {
            int[] newNums = new int[nums.length >> 1];
            for (int i = 0; i < newNums.length; i++) {
                if ((i & 1) == 1) {
                    newNums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    newNums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }
}
