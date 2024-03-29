package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/26 10:30 上午
 * @Email 794763733@qq.com
 */
public class 下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
            int index = map.get(nums1[i]);
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[index]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
