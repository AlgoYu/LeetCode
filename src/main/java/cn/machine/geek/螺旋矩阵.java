package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int row = 0, column = 0;
        int[][] next = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visitor = new boolean[m][n];
        int nextIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visitor[row][column] = true;
            int nextRow = row + next[nextIndex][0];
            int nextColumn = column + next[nextIndex][1];
            if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || visitor[nextRow][nextColumn]) {
                nextIndex = (nextIndex + 1) % 4;
            }
            row += next[nextIndex][0];
            column += next[nextIndex][1];
        }
        return order;
    }
    /**
     * 方法一：模拟
     * 可以模拟螺旋矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
     *
     * 判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的辅助矩阵 \textit{visited}visited，其中的每个元素表示该位置是否被访问过。当一个元素被访问时，将 \textit{visited}visited 中的对应位置的元素设为已访问。
     *
     * 如何判断路径是否结束？由于矩阵中的每个元素都被访问一次，因此路径的长度即为矩阵中的元素数量，当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回。
     *
     * JavaC++Python3GolangJavaScriptC
     *
     * class Solution {
     *     public List<Integer> spiralOrder(int[][] matrix) {
     *         List<Integer> order = new ArrayList<Integer>();
     *         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
     *             return order;
     *         }
     *         int rows = matrix.length, columns = matrix[0].length;
     *         boolean[][] visited = new boolean[rows][columns];
     *         int total = rows * columns;
     *         int row = 0, column = 0;
     *         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
     *         int directionIndex = 0;
     *         for (int i = 0; i < total; i++) {
     *             order.add(matrix[row][column]);
     *             visited[row][column] = true;
     *             int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
     *             if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
     *                 directionIndex = (directionIndex + 1) % 4;
     *             }
     *             row += directions[directionIndex][0];
     *             column += directions[directionIndex][1];
     *         }
     *         return order;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
     *
     * 空间复杂度：O(mn)O(mn)。需要创建一个大小为 m \times nm×n 的矩阵 \textit{visited}visited 记录每个位置是否被访问过。
     *
     * 方法二：按层模拟
     * 可以将矩阵看成若干层，首先输出最外层的元素，其次输出次外层的元素，直到输出最内层的元素。
     *
     * 定义矩阵的第 kk 层是到最近边界距离为 kk 的所有顶点。例如，下图矩阵最外层元素都是第 11 层，次外层元素都是第 22 层，剩下的元素都是第 33 层。
     *
     *
     * [[1, 1, 1, 1, 1, 1, 1],
     *  [1, 2, 2, 2, 2, 2, 1],
     *  [1, 2, 3, 3, 3, 2, 1],
     *  [1, 2, 2, 2, 2, 2, 1],
     *  [1, 1, 1, 1, 1, 1, 1]]
     * 对于每层，从左上方开始以顺时针的顺序遍历所有元素。假设当前层的左上角位于 (\textit{top}, \textit{left})(top,left)，右下角位于 (\textit{bottom}, \textit{right})(bottom,right)，按照如下顺序遍历当前层的元素。
     *
     * 从左到右遍历上侧元素，依次为 (\textit{top}, \textit{left})(top,left) 到 (\textit{top}, \textit{right})(top,right)。
     *
     * 从上到下遍历右侧元素，依次为 (\textit{top} + 1, \textit{right})(top+1,right) 到 (\textit{bottom}, \textit{right})(bottom,right)。
     *
     * 如果 \textit{left} < \textit{right}left<right 且 \textit{top} < \textit{bottom}top<bottom，则从右到左遍历下侧元素，依次为 (\textit{bottom}, \textit{right} - 1)(bottom,right−1) 到 (\textit{bottom}, \textit{left} + 1)(bottom,left+1)，以及从下到上遍历左侧元素，依次为 (\textit{bottom}, \textit{left})(bottom,left) 到 (\textit{top} + 1, \textit{left})(top+1,left)。
     *
     * 遍历完当前层的元素之后，将 \textit{left}left 和 \textit{top}top 分别增加 11，将 \textit{right}right 和 \textit{bottom}bottom 分别减少 11，进入下一层继续遍历，直到遍历完所有元素为止。
     *
     *
     *
     * JavaC++Python3GolangJavaScriptC
     *
     * class Solution {
     *     public List<Integer> spiralOrder(int[][] matrix) {
     *         List<Integer> order = new ArrayList<Integer>();
     *         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
     *             return order;
     *         }
     *         int rows = matrix.length, columns = matrix[0].length;
     *         int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
     *         while (left <= right && top <= bottom) {
     *             for (int column = left; column <= right; column++) {
     *                 order.add(matrix[top][column]);
     *             }
     *             for (int row = top + 1; row <= bottom; row++) {
     *                 order.add(matrix[row][right]);
     *             }
     *             if (left < right && top < bottom) {
     *                 for (int column = right - 1; column > left; column--) {
     *                     order.add(matrix[bottom][column]);
     *                 }
     *                 for (int row = bottom; row > top; row--) {
     *                     order.add(matrix[row][left]);
     *                 }
     *             }
     *             left++;
     *             right--;
     *             top++;
     *             bottom--;
     *         }
     *         return order;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
     *
     * 空间复杂度：O(1)O(1)。除了输出数组以外，空间复杂度是常数。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
