package cn.machine.geek;

public class 二进制矩阵中的特殊位置 {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && special(mat, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean special(int[][] mat, int i, int j) {
        for (int row = 0; row < mat.length; row++) {
            if (row == i) {
                continue;
            }
            if (mat[row][j] == 1) {
                return false;
            }
        }
        for (int col = 0; col < mat[0].length; col++) {
            if (col == j) {
                continue;
            }
            if (mat[i][col] == 1) {
                return false;
            }
        }
        return true;
    }
}
