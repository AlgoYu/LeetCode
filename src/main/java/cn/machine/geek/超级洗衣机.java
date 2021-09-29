package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/29 10:19 上午
 * @Email 794763733@qq.com
 */
public class 超级洗衣机 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += machines[i];
        }
        if (count % n != 0) {
            return -1;
        }
        int avg = count / n;
        int sum = 0, ans = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
