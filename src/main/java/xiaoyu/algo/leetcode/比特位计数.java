package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/26 12:45 下午
 * @Email 794763733@qq.com
 */
public class 比特位计数 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = total(i);
        }
        return result;
    }

    private int total(int n) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            if (n != (n >>> 1 << 1)) {
                total++;
            }
            n >>= 1;
        }
        return total;
    }
}
