package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/22 1:05 下午
 * @Email 794763733@qq.com
 */
public class 只出现一次的数字III {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int k = x == Integer.MIN_VALUE ? x : x & -x;
        int x1 = 0, x2 = 0;
        for (int num : nums) {
            if ((k & num) != 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        return new int[]{x1, x2};
    }
}
