package xiaoyu.algo.leetcode;

public class 字符串转化后的各位数字之和 {
    public int getLucky(String s, int k) {
        String temp = convert(s);
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = 0;
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                result = result + (c - '0');
            }
            temp = String.valueOf(result);
            if (temp.length() == 1) {
                return result;
            }
        }
        return result;
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((s.charAt(i) - 'a' + 1));
        }
        return sb.toString();
    }
}