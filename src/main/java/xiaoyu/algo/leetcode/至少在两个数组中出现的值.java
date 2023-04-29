package xiaoyu.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class 至少在两个数组中出现的值 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] nums = new int[101];
        int[][] datas = new int[][]{nums1, nums2, nums3};
        Set<Integer> set = new HashSet<>();
        for (int[] data : datas) {
            Set<Integer> tmp = new HashSet<>();
            for (int index : data) {
                if (tmp.contains(index)) {
                    continue;
                }
                tmp.add(index);
                nums[index]++;
                if (nums[index] >= 2) {
                    set.add(index);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
