package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/28 7:04 下午
 * @Email 794763733@qq.com
 */
public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        int index = 1;
        while (map.getOrDefault(index, false)) {
            index++;
        }
        return index;
    }
}
