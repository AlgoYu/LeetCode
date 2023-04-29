package xiaoyu.algo;

import xiaoyu.algo.leetcode.删除字符使频率相同;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AlgorithmUtil.timeStart();
        execAlgorithm();
        HashMap<String, String> hashMap = new HashMap<>();
        AlgorithmUtil.timeEnd();
    }

    private static void execAlgorithm() {
        删除字符使频率相同 test = new 删除字符使频率相同();
        test.equalFrequency("abcc");
    }
}
