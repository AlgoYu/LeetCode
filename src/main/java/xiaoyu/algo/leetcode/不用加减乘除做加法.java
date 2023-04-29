package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/14 3:28 下午
 * @Email 794763733@qq.com
 */
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
