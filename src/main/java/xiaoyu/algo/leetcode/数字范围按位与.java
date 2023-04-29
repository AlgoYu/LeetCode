package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/27 1:29 上午
 * @Email 794763733@qq.com
 */
public class 数字范围按位与 {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        for (int i = 0; i < 32; i++) {
            left = setZero(left, i);
            right = setZero(right, i);
            if (left == right) {
                return right;
            }
        }
        return 0;
    }

    private int setZero(int num, int n) {
        return num &= ~(1 << (n - 1));
    }
}
