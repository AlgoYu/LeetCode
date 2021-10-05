package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/6 12:45 上午
 * @Email 794763733@qq.com
 */
public class 第三大的数 {
    public int thirdMax(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || num > c)) {
                c = num;
            }
        }
        return c != null ? c : a;
    }
}
