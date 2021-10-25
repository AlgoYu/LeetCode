package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 7:32 下午
 * @Email 794763733@qq.com
 */
public class IP地址无效化 {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.') {
                sb.append("[.]");
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
