package xiaoyu.algo;

import xiaoyu.algo.leetcode.删除字符使频率相同;
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
        距离相等的条形码 test = new 距离相等的条形码();
        test.rearrangeBarcodes(new int[]{7, 7, 7, 8, 5, 7, 5, 5, 5, 8});
    }
}
