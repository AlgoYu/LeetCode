package cn.machine.geek;

public class 统计同构子字符串的数目 {
    private static final int K = 1000000007;

    public int countHomogenous(String s) {
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt > 0 && s.charAt(i - 1) != c) {
                result = (result + (cnt + 1) * cnt / 2) % K;
                cnt = 0;
            }
            cnt++;
        }
        if (cnt > 0) {
            result = (result + (cnt + 1) * cnt / 2) % K;
        }
        return result;
    }

    private String getKey(char ch, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
