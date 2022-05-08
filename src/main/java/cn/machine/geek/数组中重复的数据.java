package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;

public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] = -nums[num - 1];
            }
        }
        return result;
    }
}
