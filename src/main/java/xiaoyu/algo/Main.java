package xiaoyu.algo;

import xiaoyu.algo.leetcode.删除字符使频率相同;
import xiaoyu.algo.leetcode.排序数组;
import xiaoyu.algo.leetcode.矩阵对角线元素的和;
import xiaoyu.algo.leetcode.距离相等的条形码;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;

public class Main {
    int[] arraysData = new int[]{1, 2, 3, 4};

    public static void main(String[] args) {
        AlgorithmUtil.timeStart();
        execAlgorithm();
        AlgorithmUtil.timeEnd();
    }

    private static void execAlgorithm() {
        Solution test = new Solution();
        test.solveSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
    }
}
