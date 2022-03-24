package cn.machine.geek;

public class 图片平滑器 {
    private static final int[][] DIRECT = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        if (n == 0) {
            return img;
        }
        int m = img[0].length;
        if (m == 0) {
            return img;
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                float count = 1F;
                int sum = img[i][j];
                for (int[] direct : DIRECT) {
                    int row = i + direct[0];
                    int col = j + direct[1];
                    if (row >= 0 && col >= 0 && row < n && col < m) {
                        count++;
                        sum += img[row][col];
                    }
                }
                result[i][j] = (int) Math.floor(sum / count);
            }
        }
        return result;
    }
}
