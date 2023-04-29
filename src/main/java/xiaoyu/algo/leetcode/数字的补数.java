package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/18 12:53 下午
 * @Email 794763733@qq.com
 */
public class 数字的补数 {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num == (num >> 1 << 1)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            num >>= 1;
        }
        int result = 0;
        int bei = 1;
        for (int i = 0; i < sb.length(); i++) {
            if (i >= 1) {
                bei *= 2;
            }
            result = result + ((sb.charAt(i) - '0') * bei);
        }
        return result;
    }

    public int findComplementA(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
