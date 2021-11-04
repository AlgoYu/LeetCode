package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/5 12:28 上午
 * @Email 794763733@qq.com
 */
public class 最长定差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }
}
