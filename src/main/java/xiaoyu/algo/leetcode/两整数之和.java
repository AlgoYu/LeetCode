package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/26 3:46 下午
 * @Email 794763733@qq.com
 */
public class 两整数之和 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
