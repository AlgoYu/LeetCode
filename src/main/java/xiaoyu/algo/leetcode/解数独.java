package xiaoyu.algo.leetcode;

public class 解数独 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num
                    || board[row][i] == num
                    || board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean backtrack(char[][] board, int row, int col) {
        if (row >= board.length) {
            return true;
        }
        int nextCol = (col + 1) % board[row].length;
        int nextRow = nextCol == 0 ? row + 1 : row;
        if (board[row][col] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (backtrack(board, nextRow, nextCol)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        } else {
            return backtrack(board, nextRow, nextCol);
        }
        return false;
    }
}
