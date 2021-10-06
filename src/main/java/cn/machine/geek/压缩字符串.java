package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/6 9:28 下午
 * @Email 794763733@qq.com
 */
public class 压缩字符串 {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        int preCount = 1;
        char pre = chars[0];
        StringBuilder sb = new StringBuilder(pre);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                preCount++;
                continue;
            }
            sb.append(pre);
            if (preCount > 1) {
                sb.append(preCount);
            }
            pre = chars[i];
            preCount = 1;
        }
        if (preCount > 0) {
            sb.append(pre);
        }
        if (preCount > 1) {
            sb.append(preCount);
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
