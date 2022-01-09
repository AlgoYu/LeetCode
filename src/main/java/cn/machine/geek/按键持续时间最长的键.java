package cn.machine.geek;

public class 按键持续时间最长的键 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int max = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int cur = releaseTimes[i] - releaseTimes[i - 1];
            if (cur >= max) {
                char curChar = keysPressed.charAt(i);
                if (cur > max) {
                    max = cur;
                    maxChar = curChar;
                } else if (curChar > maxChar) {
                    maxChar = curChar;
                }
            }
        }
        return maxChar;
    }
}
