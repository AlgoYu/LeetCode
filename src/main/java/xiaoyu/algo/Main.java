package xiaoyu.algo;

import xiaoyu.algo.leetcode.*;

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
        Three的幂 t = new Three的幂();
        t.isPowerOfThree(0);
    }
}
