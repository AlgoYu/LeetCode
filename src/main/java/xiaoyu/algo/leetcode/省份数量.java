package xiaoyu.algo.leetcode;

public class 省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 1) {
            return n;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] != 1) {
                    continue;
                }
                unite(parent, j, p);
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                total++;
            }
        }
        return total;
    }

    private void unite(int[] parent, int a, int b) {
        parent[find(parent, a)] = find(parent, b);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
