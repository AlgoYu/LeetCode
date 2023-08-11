package xiaoyu.algo.leetcode;

public class 矩阵对角线元素的和 {
    /*
     *
     * [7,3,1,9],
     * [3,4,6,9],
     * [6,9,6,6],
     * [9,5,8,5]
     * */
    public int diagonalSum(int[][] mat) {
        int result = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            result += mat[i][i];
            int reverse = n - 1 - i;
            if (i != reverse || (n & 1) != 1) {
                result += mat[i][reverse];
            }
        }
        return result;
    }
}
