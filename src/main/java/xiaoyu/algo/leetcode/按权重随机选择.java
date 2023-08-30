package xiaoyu.algo.leetcode;

import java.util.Arrays;
import java.util.Random;

public class 按权重随机选择 {
    int[] pre;
    int[] w;

    public 按权重随机选择(int[] w) {
        this.w = w;
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int x = (int) (Math.random() * pre[pre.length - 1]) + 1;
        int l = 0, r = pre.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (pre[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
