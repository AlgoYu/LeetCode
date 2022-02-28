package cn.machine.geek;

public class 找出星型图的中心节点 {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] nodes = new int[n + 1];
        for (int[] edge : edges) {
            nodes[edge[0]]++;
            nodes[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (nodes[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
