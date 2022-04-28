package cn.machine.geek;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 太平洋大西洋水流问题 {
    private static final int[][] DIRECTS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacificOcean = new boolean[n][m];
        boolean[][] atlanticOcean = new boolean[n][m];

        // 遍历太平洋
        for (int i = 0; i < m; i++) {
            dfs(pacificOcean, heights, 0, i, n, m);
        }
        for (int i = 0; i < n; i++) {
            dfs(pacificOcean, heights, i, 0, n, m);
        }
        // 遍历大西洋
        for (int i = 0; i < m; i++) {
            dfs(atlanticOcean, heights, n - 1, i, n, m);
        }
        for (int i = 0; i < n; i++) {
            dfs(atlanticOcean, heights, i, m - 1, n, m);
        }

        // 大西洋和太平洋都可以去的地方
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificOcean[i][j] && atlanticOcean[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] ocean, int[][] heights, int row, int col, int n, int m) {
        ocean[row][col] = true;
        for (int[] direct : DIRECTS) {
            int nextRow = row + direct[0];
            int nextCol = col + direct[1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) {
                continue;
            }
            if (ocean[nextRow][nextCol] || heights[row][col] > heights[nextRow][nextCol]) {
                continue;
            }
            dfs(ocean, heights, nextRow, nextCol, n, m);
        }
    }
}
