package xiaoyu.algo.leetcode;

public class 完美矩形 {
    public boolean isRectangleCover(int[][] rectangles) {
        int totalArea = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            // 覆盖
            for (int j = i + 1; j < rectangles.length; j++) {
                // 覆盖直接错误
                if (over(rectangles[i], rectangles[j])) {
                    return false;
                }
            }
            // 加上面积
            totalArea += getArea(rectangles[i]);
            // 取最小x,y
            minX = Math.min(rectangles[i][0], minX);
            minY = Math.min(rectangles[i][1], minY);
            // 取最大x,y
            maxX = Math.max(rectangles[i][2], maxX);
            maxY = Math.max(rectangles[i][3], maxY);
        }
        return totalArea == (maxX - minX) * (maxY - minY);
    }

    private int getArea(int[] rectangle) {
        int x = rectangle[2] - rectangle[0];
        int y = rectangle[3] - rectangle[1];
        return x * y;
    }

    private boolean over(int[] rectangleA, int[] rectangleB) {
        // 最小的右边 - 最大的左边
        int overX = Math.min(rectangleA[2], rectangleB[2]) - Math.max(rectangleA[0], rectangleB[0]);
        // 最小的上边 - 最大的下边
        int overY = Math.min(rectangleA[3], rectangleB[3]) - Math.max(rectangleA[1], rectangleB[1]);
        return Math.max(overX, 0) * Math.max(overY, 0) > 0;
    }
}
