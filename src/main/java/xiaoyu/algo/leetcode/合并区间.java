package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/6 8:27 下午
 * @Email 794763733@qq.com
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        int index = 0;
        List<int[]> result = new ArrayList<>();
        while (index < n) {
            int[] ints = intervals[index];
            int left = ints[0];
            int right = ints[1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
                continue;
            }
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            index++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
