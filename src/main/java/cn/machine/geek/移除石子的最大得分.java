package cn.machine.geek;

import java.util.Arrays;

public class 移除石子的最大得分 {
    public int maximumScore(int a, int b, int c) {
        int[] nums = new int[]{a, b, c};
        int result = 0;
        for (; ; ) {
            Arrays.sort(nums);
            if (nums[0] == 0 && nums[1] == 0) {
                return result;
            }
            nums[1]--;
            nums[2]--;
            result++;
        }
    }
}
