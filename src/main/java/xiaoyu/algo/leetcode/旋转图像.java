package xiaoyu.algo.leetcode;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n >> 1); i++) {
            for (int j = i; j < n - 1 - i; j++) {
                swap(matrix, i, j, j, n - 1 - i);
                swap(matrix, i, j, n - 1 - i, n - 1 - j);
                swap(matrix, i, j, n - 1 - j, i);
            }
        }
    }

    public void swap(int[][] matrix, int p1, int p2, int p3, int p4) {
        int temp = matrix[p1][p2];
        matrix[p1][p2] = matrix[p3][p4];
        matrix[p3][p4] = temp;
    }

    /**
     * 转置加翻转
     * 最直接的想法是先转置矩阵，然后翻转每一行。这个简单的方法已经能达到最优的时间复杂度O(N^2)O(N
     * 2
     * )。
     * <p>
     * JavaPython
     * <p>
     * class Solution {
     * public void rotate(int[][] matrix) {
     * int n = matrix.length;
     * <p>
     * // transpose matrix
     * for (int i = 0; i < n; i++) {
     * for (int j = i; j < n; j++) {
     * int tmp = matrix[j][i];
     * matrix[j][i] = matrix[i][j];
     * matrix[i][j] = tmp;
     * }
     * }
     * // reverse each row
     * for (int i = 0; i < n; i++) {
     * for (int j = 0; j < n / 2; j++) {
     * int tmp = matrix[i][j];
     * matrix[i][j] = matrix[i][n - j - 1];
     * matrix[i][n - j - 1] = tmp;
     * }
     * }
     * }
     * }
     * 时间复杂度：O(N^2)O(N
     * 2
     * ).
     * 空间复杂度：O(1)O(1) 由于旋转操作是 就地 完成的。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。转置加翻转
     * 最直接的想法是先转置矩阵，然后翻转每一行。这个简单的方法已经能达到最优的时间复杂度O(N^2)O(N
     * 2
     * )。
     * <p>
     * JavaPython
     * <p>
     * class Solution {
     * public void rotate(int[][] matrix) {
     * int n = matrix.length;
     * <p>
     * // transpose matrix
     * for (int i = 0; i < n; i++) {
     * for (int j = i; j < n; j++) {
     * int tmp = matrix[j][i];
     * matrix[j][i] = matrix[i][j];
     * matrix[i][j] = tmp;
     * }
     * }
     * // reverse each row
     * for (int i = 0; i < n; i++) {
     * for (int j = 0; j < n / 2; j++) {
     * int tmp = matrix[i][j];
     * matrix[i][j] = matrix[i][n - j - 1];
     * matrix[i][n - j - 1] = tmp;
     * }
     * }
     * }
     * }
     * 时间复杂度：O(N^2)O(N
     * 2
     * ).
     * 空间复杂度：O(1)O(1) 由于旋转操作是 就地 完成的。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void rotateOfficial1(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    /**
     * 旋转四个矩形
     * 直观想法
     * <p>
     * 方法 1 使用了两次矩阵操作，但是有只使用一次操作的方法完成旋转。
     * <p>
     * 为了实现这一点，我们来研究每个元素在旋转的过程中如何移动。
     * <p>
     * <p>
     * <p>
     * 这提供给我们了一个思路，将给定的矩阵分成四个矩形并且将原问题划归为旋转这些矩形的问题。
     * <p>
     * <p>
     * <p>
     * 现在的解法很直接 - 可以在第一个矩形中移动元素并且在 长度为 4 个元素的临时列表中移动它们。
     * <p>
     * <p>
     * 1 / 6
     * <p>
     * 代码
     * <p>
     * JavaPython
     * <p>
     * class Solution {
     * public void rotate(int[][] matrix) {
     * int n = matrix.length;
     * for (int i = 0; i < n / 2 + n % 2; i++) {
     * for (int j = 0; j < n / 2; j++) {
     * int[] tmp = new int[4];
     * int row = i;
     * int col = j;
     * for (int k = 0; k < 4; k++) {
     * tmp[k] = matrix[row][col];
     * int x = row;
     * row = col;
     * col = n - 1 - x;
     * }
     * for (int k = 0; k < 4; k++) {
     * matrix[row][col] = tmp[(k + 3) % 4];
     * int x = row;
     * row = col;
     * col = n - 1 - x;
     * }
     * }
     * }
     * }
     * }
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N^2)O(N
     * 2
     * ) 是两重循环的复杂度。
     * 空间复杂度：O(1)O(1) 由于我们在一次循环中的操作是 就地 完成的，并且我们只用了长度为 4 的临时列表做辅助。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void rotateOfficial2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    /**
     * 在单次循环中旋转 4 个矩形
     * 该想法和方法 2 相同，但是所有的操作可以在单次循环内完成并且这是更精简的方法。
     * <p>
     * JavaPython
     * <p>
     * class Solution {
     * public void rotate(int[][] matrix) {
     * int n = matrix.length;
     * for (int i = 0; i < (n + 1) / 2; i ++) {
     * for (int j = 0; j < n / 2; j++) {
     * int temp = matrix[n - 1 - j][i];
     * matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
     * matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
     * matrix[j][n - 1 - i] = matrix[i][j];
     * matrix[i][j] = temp;
     * }
     * }
     * }
     * }
     * 时间复杂度：O(N^2)O(N
     * 2
     * ) 是两重循环的复杂度。
     * 空间复杂度：O(1)O(1) 由于旋转操作是 就地 完成的。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void rotateOfficial3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
