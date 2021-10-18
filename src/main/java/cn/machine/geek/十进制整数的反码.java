package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/18 6:50 下午
 * @Email 794763733@qq.com
 */
public class 十进制整数的反码 {
    public int bitwiseComplement(int num) {
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
}
