package cn.machine.geek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 矩阵中的幸运数 {
    private static final int K = 51;

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int min = matrix[i][0];
            int minRow = i;
            int minCol = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
            queue.offer(minRow * K + minCol);
        }
        X:
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int row = poll / K;
            int col = poll % K;
            int max = matrix[row][col];
            for (int i = 0; i < n; i++) {
                if (matrix[i][col] > max) {
                    continue X;
                }
            }
            list.add(max);
        }
        return list;
    }
}
