package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/26 1:09 下午
 * @Email 794763733@qq.com
 */
public class 外观数列 {
    public String countAndSay(int n) {
        String initValue = "1";
        while (n > 1) {
            initValue = seq(initValue);
            n--;
        }
        return initValue;
    }

    private String seq(String seq) {
        if (seq == null || "".equals(seq)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = seq.charAt(0);
        for (int i = 1; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (ch != c) {
                sb.append(count);
                sb.append(ch);
                count = 1;
                ch = c;
                continue;
            }
            count++;
        }
        if (count > 0) {
            sb.append(count);
            sb.append(ch);
        }
        return sb.toString();
    }
}
