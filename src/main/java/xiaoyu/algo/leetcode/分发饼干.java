package xiaoyu.algo.leetcode;

import java.util.Arrays;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/29 1:50 下午
 * @Email 794763733@qq.com
 */
public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        int total = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                total++;
                gi++;
            }
            si++;
        }
        return total;
    }
}
