package cn.machine.geek;

public class 找到最高海拔 {
    public int largestAltitude(int[] gain) {
        int init = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            init += gain[i];
            max = Math.max(init, max);
        }
        return max;
    }
}