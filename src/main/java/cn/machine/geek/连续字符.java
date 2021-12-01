package cn.machine.geek;

public class 连续字符 {
    public int maxPower(String s) {
        int n = s.length();
        if (n == 0) {
            return n;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            int cur = 1;
            char ch = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                if (ch != s.charAt(j)) {
                    i = j - 1;
                    break;
                }
                cur++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
