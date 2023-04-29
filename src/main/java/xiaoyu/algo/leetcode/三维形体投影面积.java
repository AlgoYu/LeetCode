package xiaoyu.algo.leetcode;

public class 三维形体投影面积 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int top = 0;
        int side = 0;
        int front = 0;
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    top++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            side += maxRow;
            front += maxCol;
        }
        return top + side + front;
    }
}
