package cn.machine.geek;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int n = 1;
            num++;
            while (set.contains(num)) {
                n++;
                num++;
            }
            max = Math.max(max, n);
        }
        return max;
    }
}
