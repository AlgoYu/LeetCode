package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    int count = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == '.') {
                    continue;

                }
                bfs(grid, i, j);
                count++;
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '.';
        bfs(grid, i - 1, j);
        bfs(grid, i + 1, j);
        bfs(grid, i, j - 1);
        bfs(grid, i, j + 1);
    }
}
