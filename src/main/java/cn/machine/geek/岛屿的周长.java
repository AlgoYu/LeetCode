package cn.machine.geek;

public class 岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count += getBoundsLength(grid, i, j);
            }
        }
        return count;
    }

    private int getBoundsLength(int[][] grid, int row, int col) {
        int boundsLength = 0;
        if (row == 0 || grid[row][col] != grid[row - 1][col]) {
            boundsLength += 1;
        }
        if (col == 0 || grid[row][col] != grid[row][col - 1]) {
            boundsLength += 1;
        }
        if (row == grid.length - 1 || grid[row][col] != grid[row + 1][col]) {
            boundsLength += 1;
        }
        if (col == grid[row].length - 1 || grid[row][col] != grid[row][col + 1]) {
            boundsLength += 1;
        }
        return boundsLength;
    }
}
