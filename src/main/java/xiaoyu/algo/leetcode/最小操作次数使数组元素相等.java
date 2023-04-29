package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/20 10:29 上午
 * @Email 794763733@qq.com
 */
public class 最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
