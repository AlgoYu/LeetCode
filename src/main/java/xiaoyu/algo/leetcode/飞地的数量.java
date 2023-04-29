package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class 飞地的数量 {
    // 用于记录下标的乘数
    private static final int K = 501;
    // 上下左右方向
    private static final int[][] DIRECT = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 标记访问过的节点
        int[][] visited = new int[n][m];
        // 用来记录坐标
        Queue<Integer> queue = new LinkedList<>();
        // 外层绕一圈，找出是陆地的，加到队列里去。
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                queue.offer(i);
            }
            if (grid[n - 1][i] == 1) {
                queue.offer((n - 1) * K + i);
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.offer(i * K);
            }
            if (grid[i][m - 1] == 1) {
                queue.offer(i * K + m - 1);
            }
        }
        int row = 0, col = 0;
        // 广度优先遍历
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            row = cur / K;
            col = cur % K;
            // 标记是可以跨出边界的
            visited[row][col] = 1;
            for (int i = 0; i < DIRECT.length; i++) {
                int dRow = row + DIRECT[i][0];
                int dCol = col + DIRECT[i][1];
                if (dRow < 0 || dCol < 0 || dRow == n || dCol == m) {
                    continue;
                }
                if (visited[dRow][dCol] != 0 || grid[dRow][dCol] != 1) {
                    continue;
                }
                queue.offer(dRow * K + dCol);
            }
        }
        // 遍历内部，找出是陆地，但是无法跨出边界的总数。
        int total = 0;
        for (row = 1; row < n - 1; row++) {
            for (col = 1; col < m - 1; col++) {
                if (grid[row][col] == 1 && visited[row][col] == 0) {
                    total++;
                }
            }
        }
        return total;
    }
}
