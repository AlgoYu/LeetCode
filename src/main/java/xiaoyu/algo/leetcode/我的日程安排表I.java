package xiaoyu.algo.leetcode;

import java.util.TreeSet;

public class 我的日程安排表I {
    TreeSet<int[]> treeSet;

    public 我的日程安排表I() {
        treeSet = new TreeSet<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
    }

    public boolean book(int start, int end) {
        if (treeSet.isEmpty()) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        int[] arr = treeSet.ceiling(tmp);
        int[] prev = arr == null ? treeSet.last() : treeSet.lower(arr);
        if (arr == treeSet.first() || prev[1] <= start) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}
