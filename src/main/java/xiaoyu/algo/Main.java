package xiaoyu.algo;

import xiaoyu.algo.leetcode.删除字符使频率相同;
import xiaoyu.algo.leetcode.排序数组;
import xiaoyu.algo.leetcode.矩阵对角线元素的和;
import xiaoyu.algo.leetcode.距离相等的条形码;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AlgorithmUtil.timeStart();
        execAlgorithm();
        AlgorithmUtil.timeEnd();
    }

    private static void execAlgorithm() {
        Solution test = new Solution();
        test.exchange(new int[]{1, 2, 3, 4});
    }
}
