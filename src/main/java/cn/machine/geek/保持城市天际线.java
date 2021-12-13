package cn.machine.geek;

public class 保持城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowHeight = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowHeight[i] = Math.max(rowHeight[i], grid[i][j]);
            }
        }
        int[] colHeight = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                colHeight[i] = Math.max(colHeight[i], grid[j][i]);
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int n = grid[i][j];
                max += Math.min(rowHeight[i], colHeight[j]) - n;
            }
        }
        return max;
    }
}
