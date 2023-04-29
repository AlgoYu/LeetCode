package xiaoyu.algo.leetcode;

/**
 * @Author: MachineGeek
 * @Description:
 * @Email: 794763733@qq.com
 * @Date: 2021/3/30
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        while (row < matrix.length && target >= matrix[row][0]) {
            if (target == matrix[row][0]) {
                return true;
            }
            row++;
        }
        int[] datas = matrix[Math.max(0, row - 1)];
        int l = 0, r = datas.length;
        int mid = (l + r) >> 1;
        int preMid = -1;
        while (mid != preMid && l < r) {
            if (datas[mid] > target) {
                r = mid;
            } else if (datas[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
            preMid = mid;
            mid = (l + r) >> 1;
        }
        return false;
    }

    /**
     * 两次二分查找
     * 思路
     *
     * 由于每行的第一个元素大于前一行的最后一个元素，且每行元素是升序的，所以每行的第一个元素大于前一行的第一个元素，因此矩阵第一列的元素是升序的。
     *
     * 我们可以对矩阵的第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
     *
     * 代码
     *
     * C++JavaGolangJavaScriptC
     *
     * class Solution {
     *     public boolean searchMatrix(int[][] matrix, int target) {
     *         int rowIndex = binarySearchFirstColumn(matrix, target);
     *         if (rowIndex < 0) {
     *             return false;
     *         }
     *         return binarySearchRow(matrix[rowIndex], target);
     *     }
     *
     *     public int binarySearchFirstColumn(int[][] matrix, int target) {
     *         int low = -1, high = matrix.length - 1;
     *         while (low < high) {
     *             int mid = (high - low + 1) / 2 + low;
     *             if (matrix[mid][0] <= target) {
     *                 low = mid;
     *             } else {
     *                 high = mid - 1;
     *             }
     *         }
     *         return low;
     *     }
     *
     *     public boolean binarySearchRow(int[] row, int target) {
     *         int low = 0, high = row.length - 1;
     *         while (low <= high) {
     *             int mid = (high - low) / 2 + low;
     *             if (row[mid] == target) {
     *                 return true;
     *             } else if (row[mid] > target) {
     *                 high = mid - 1;
     *             } else {
     *                 low = mid + 1;
     *             }
     *         }
     *         return false;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\log m+\log n)=O(\log mn)O(logm+logn)=O(logmn)，其中 mm 和 nn 分别是矩阵的行数和列数。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 方法二：一次二分查找
     * 思路
     *
     * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
     *
     * 代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上。
     *
     * 代码
     *
     * C++JavaGolangJavaScriptC
     *
     * class Solution {
     *     public boolean searchMatrix(int[][] matrix, int target) {
     *         int m = matrix.length, n = matrix[0].length;
     *         int low = 0, high = m * n - 1;
     *         while (low <= high) {
     *             int mid = (high - low) / 2 + low;
     *             int x = matrix[mid / n][mid % n];
     *             if (x < target) {
     *                 low = mid + 1;
     *             } else if (x > target) {
     *                 high = mid - 1;
     *             } else {
     *                 return true;
     *             }
     *         }
     *         return false;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\log mn)O(logmn)，其中 mm 和 nn 分别是矩阵的行数和列数。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 结语
     * 两种方法殊途同归，都利用了二分查找，在二维矩阵上寻找目标值。值得注意的是，若二维数组中的一维数组的元素个数不一，方法二将会失效，而方法一则能正确处理。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
