package xiaoyu.algo.leetcode;

import java.util.Arrays;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/10 9:55 下午
 * @Email 794763733@qq.com
 */
public class H指数 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // [0,1,3,5,6]
        // [0,23,1000,1000,1000]
        int index = citations.length - 1;
        int h = 0;
        while (index >= 0 && citations[index] >= h) {
            h++;
            index--;
        }
        return h;
    }
}
