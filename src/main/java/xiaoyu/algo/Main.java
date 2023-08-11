package xiaoyu.algo;

import xiaoyu.algo.leetcode.删除字符使频率相同;
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
        矩阵对角线元素的和 test = new 矩阵对角线元素的和();
        test.diagonalSum(new int[][]{{7, 3, 1, 9}, {3, 4, 6, 9}, {6, 9, 6, 6}, {9, 5, 8, 5}});
    }
}
