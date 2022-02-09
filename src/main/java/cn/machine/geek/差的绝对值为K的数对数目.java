package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/30 4:52 下午
 * @Email 794763733@qq.com
 */
public class 差的绝对值为K的数对数目 {
    public int countKDifference(int[] nums, int k) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            total += map.getOrDefault(num + k, 0);
            total += map.getOrDefault(num - k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return total;
    }
}
