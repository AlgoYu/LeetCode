package cn.machine.geek;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    private int count;
    private static int N;

    public int numIslands(char[][] grid) {
        N = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                bfs(grid, i, j);
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(row * N + col);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            int tRow = num / N;
            int tCol = num % N;
            if (tRow > 0 && grid[tRow - 1][tCol] == '1') {
                queue.add((tRow - 1) * N + tCol);
                grid[tRow - 1][tCol] = '0';
            }
            if (tRow + 1 < grid.length && grid[tRow + 1][tCol] == '1') {
                queue.add((tRow + 1) * N + tCol);
                grid[tRow + 1][tCol] = '0';
            }
            if (tCol > 0 && grid[tRow][tCol - 1] == '1') {
                queue.add(tRow * N + (tCol - 1));
                grid[tRow][tCol - 1] = '0';
            }
            if (tCol + 1 < grid[0].length && grid[tRow][tCol + 1] == '1') {
                queue.add(tRow * N + (tCol + 1));
                grid[tRow][tCol + 1] = '0';
            }
        }
        count++;
    }
}
