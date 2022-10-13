package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

public class 最多能完成排序的块 {
    public int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }
}