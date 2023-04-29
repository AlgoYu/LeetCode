package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                continue;
            }
            nums[num - 1] = -nums[num - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
