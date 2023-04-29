package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 二维网格迁移 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int row = (i + (j + k) / m) % n;
                int col = (j + k) % m;
                temp[row][col] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(temp[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
