package cn.machine.geek;

public class 最大的以1为边界的正方形 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] left = new int[n][m];
        int[][] top = new int[n][m];

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    // 初始状态
                    top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;

                    // 如果下边和右边都有线，取最短的那个遍历，从大到小遍历一下长度
                    for (int k = Math.min(top[i][j], left[i][j]); k >= 0; k--) {
                        // 下标长度
                        int il = k - 1;
                        // 左边的线和上边的线不能比这个短
                        if (top[i][j - il] >= k && left[i - il][j] >= k) {
                            maxLength = Math.max(maxLength, k);
                            break;
                        }
                    }
                }
            }
        }

        return maxLength * maxLength;
    }
}
