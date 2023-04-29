package xiaoyu.algo.leetcode;

public class 奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] data = new int[m][n];
        for (int[] indic : indices) {
            int row = indic[0];
            int col = indic[1];
            for (int i = 0; i < m; i++) {
                data[i][col]++;
            }
            for (int i = 0; i < n; i++) {
                data[row][i]++;
            }
        }
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((data[i][j] & 1) == 1) {
                    num++;
                }
            }
        }
        return num;
    }
}
