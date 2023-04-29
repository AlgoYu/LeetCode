package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 10:46 上午
 * @Email 794763733@qq.com
 */
public class 搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length && matrix[i][0] <= target; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (array[mid] == target) {
                return true;
            }
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
