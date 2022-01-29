package cn.machine.geek;

import java.util.LinkedList;
import java.util.Queue;

public class 地图中的最高点 {
    private static final int K = 1001;
    private static final int[][] DIRECTS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] result = new int[n][m];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.offer(K * i + j);
                    continue;
                }
                result[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            int r = num / K;
            int w = num % K;
            for (int[] direct : DIRECTS) {
                int nextRow = r + direct[0];
                int nextCol = w + direct[1];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || result[nextRow][nextCol] != -1) {
                    continue;
                }
                result[nextRow][nextCol] = result[r][w] + 1;
                queue.offer(nextRow * K + nextCol);
            }
        }
        return result;
    }
}
