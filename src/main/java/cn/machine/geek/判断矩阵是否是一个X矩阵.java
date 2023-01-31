package cn.machine.geek;

public class 判断矩阵是否是一个X矩阵 {
    public static void main(String[] args) {
        判断矩阵是否是一个X矩阵 s = new 判断矩阵是否是一个X矩阵();
        s.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}});
    }

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == j || i == Math.abs(m - 1 - j))) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
