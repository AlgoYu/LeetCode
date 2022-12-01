package cn.machine.geek;

public class 找到最近的有相同X或Y坐标的点 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < points.length; i++) {
            int tx = points[i][0];
            int ty = points[i][1];
            if (tx == x || ty == y) {
                int tMin = Math.abs((x - tx)) + Math.abs((y - ty));
                if (tMin < min) {
                    result = i;
                    min = tMin;
                }
            }
        }
        return result;
    }
}