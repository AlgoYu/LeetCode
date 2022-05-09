package cn.machine.geek;

public class 增减字符串匹配 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int min = 0, max = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = min;
                min++;
            } else {
                result[i] = max;
                max--;
            }
        }
        result[n] = min;
        return result;
    }
}
