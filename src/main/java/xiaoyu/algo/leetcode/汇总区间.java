package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/1 12:39 下午
 * @Email 794763733@qq.com
 */
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int pre = 0;
        int index = 0;
        while (index < nums.length) {
            while (index + 1 < nums.length && nums[index] == nums[index + 1] - 1) {
                index++;
            }
            if (pre == index) {
                result.add(nums[index] + "");
            } else {
                result.add(nums[pre] + "->" + nums[index]);
            }
            index++;
            pre = index;
        }
        return result;
    }
}
