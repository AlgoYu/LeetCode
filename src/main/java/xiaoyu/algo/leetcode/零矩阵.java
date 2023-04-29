package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 零矩阵 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int P = Math.max(n, m) + 10;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i * P + j);
                }
            }
        }
        for (Integer l : list) {
            int row = l / P;
            int col = l % P;
            for (int i = 0; i < n; i++) {
                matrix[i][col] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[row][i] = 0;
            }
        }
    }
}
