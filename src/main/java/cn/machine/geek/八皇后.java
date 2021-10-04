package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/4 1:51 下午
 * @Email 794763733@qq.com
 */
public class 八皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        solveNQueens(n, result, new int[n], 0);
        return result;
    }

    public List<List<String>> solveNQueens(int n, List<List<String>> result, int[] queens, int row) {
        if (row >= n) {
            result.add(generateString(queens));
            return result;
        }
        for (int column = 0; column < n; column++) {
            if (isValidPoint(queens, row, column)) {
                queens[row] = column;
                solveNQueens(n, result, queens, row + 1);
            }
        }
        return result;
    }

    private boolean isValidPoint(int[] queens, int row, int column) {
        for (int i = 0; i < row; i++) {
            // 同列或同斜边
            if (queens[i] == column || Math.abs(row - i) == Math.abs(column - queens[i])) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateString(int[] queens) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int N = queens.length;
        for (int i = 0; i < N; i++) {
            sb.delete(0, sb.length());
            int j = 0;
            while (j < queens[i]) {
                sb.append('.');
                j++;
            }
            sb.append('Q');
            while (sb.length() < queens.length) {
                sb.append('.');
                j++;
            }
            list.add(sb.toString());
        }
        return list;
    }
}
