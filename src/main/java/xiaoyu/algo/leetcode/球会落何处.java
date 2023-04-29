package xiaoyu.algo.leetcode;

public class 球会落何处 {
    public int[] findBall(int[][] grid) {
        int[] answer = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            answer[i] = dfs(grid, 0, i);
        }
        return answer;
    }

    private int dfs(int[][] grid, int level, int col) {
        if (level >= grid.length) {
            return col;
        }
        int board = grid[level][col];
        if (board == 1 && col + 1 < grid[level].length && grid[level][col + 1] == 1) {
            return dfs(grid, level + 1, col + 1);
        }
        if (board == -1 && col - 1 >= 0 && grid[level][col - 1] == -1) {
            return dfs(grid, level + 1, col - 1);
        }
        return -1;
    }
}
