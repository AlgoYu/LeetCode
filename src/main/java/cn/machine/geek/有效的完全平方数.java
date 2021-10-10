package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/10 2:53 下午
 * @Email 794763733@qq.com
 */
public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 0, right = num / 2, mid = 0;
        long n = 0;
        while (left <= right) {
            mid = left + (right - left >> 1);
            n = mid * mid;
            if (n == num) {
                return true;
            }
            if (n > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
