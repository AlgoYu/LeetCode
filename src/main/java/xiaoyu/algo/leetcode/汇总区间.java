package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        int pre = 0, index = 0;
        while (index < n) {
            while (index + 1 < n && nums[index] + 1 == nums[index + 1]) {
                index++;
            }
            if (pre == index) {
                result.add(String.valueOf(nums[index]));
            } else {
                result.add(nums[pre] + "->" + nums[index]);
            }
            pre = index + 1;
            index = pre;
        }
        return result;
    }
}
