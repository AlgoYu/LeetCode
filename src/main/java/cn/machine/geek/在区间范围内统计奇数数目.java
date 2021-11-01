package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/1 11:17 上午
 * @Email 794763733@qq.com
 */
public class 在区间范围内统计奇数数目 {
    public int countOdds(int low, int high) {
        int n = 0;
        for (int i = low; i <= high; i++) {
            if ((i & 1) == 1) {
                n++;
            }
        }
        return n;
    }
}
