package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/4 1:42 下午
 * @Email 794763733@qq.com
 */
public class N皇后II {
    private int count;
    private int[] queens;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        count = 0;
        queens = new int[n];
        return totalNQueens(n, 0);
    }

    private int totalNQueens(int n, int row) {
        if (row >= n) {
            return ++count;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(i, row)) {
                queens[row] = i;
                totalNQueens(n, row + 1);
            }
        }
        return count;
    }

    private boolean isValid(int column, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == column || Math.abs(row - i) == Math.abs(column - queens[i])) {
                return false;
            }
        }
        return true;
    }
}
