package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/24 10:40 下午
 * @Email 794763733@qq.com
 */
public class 拆炸弹 {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            for (int j = 1; j <= Math.abs(k); j++) {
                if (k > 0) {
                    result[i] += code[(i + j) % code.length];
                } else {
                    result[i] += code[i - j < 0 ? i - j + code.length : i - j];
                }
            }
        }
        return result;
    }
}
