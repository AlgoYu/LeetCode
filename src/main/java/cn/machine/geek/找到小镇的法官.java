package cn.machine.geek;

public class 找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        boolean[] edge = new boolean[n + 1];
        int[] count = new int[n + 1];
        for (int[] trs : trust) {
            edge[trs[0]] = true;
            count[trs[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (!edge[i] && count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
