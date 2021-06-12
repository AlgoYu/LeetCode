package cn.machine.geek;

import java.util.PriorityQueue;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[2][m];
        int last = 0, next = 1;
        for (int i = 0; i < n; i++) {
            last = next;
            next = 1 - next;
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[next][j] = grid[i][j];
                    continue;
                }
                if (i == 0 && j > 0) {
                    dp[next][j] = grid[i][j] + dp[next][j - 1];
                    continue;
                }
                if (i > 0 && j == 0) {
                    dp[next][j] = grid[i][j] + dp[last][j];
                    continue;
                }
                dp[next][j] = Math.min(dp[next][j - 1], dp[last][j]) + grid[i][j];
            }
        }
        return dp[next][m - 1];
    }
    /**
     * 方法一：动态规划
     * 由于路径的方向只能是向下或向右，因此网格的第一行的每个元素只能从左上角元素开始向右移动到达，网格的第一列的每个元素只能从左上角元素开始向下移动到达，此时的路径是唯一的，因此每个元素对应的最小路径和即为对应的路径上的数字总和。
     *
     * 对于不在第一行和第一列的元素，可以从其上方相邻元素向下移动一步到达，或者从其左方相邻元素向右移动一步到达，元素对应的最小路径和等于其上方相邻元素与其左方相邻元素两者对应的最小路径和中的最小值加上当前元素的值。由于每个元素对应的最小路径和与其相邻元素对应的最小路径和有关，因此可以使用动态规划求解。
     *
     * 创建二维数组 \textit{dp}dp，与原始网格的大小相同，\textit{dp}[i][j]dp[i][j] 表示从左上角出发到 (i,j)(i,j) 位置的最小路径和。显然，\textit{dp}[0][0]=\textit{grid}[0][0]dp[0][0]=grid[0][0]。对于 \textit{dp}dp 中的其余元素，通过以下状态转移方程计算元素值。
     *
     * 当 i>0i>0 且 j=0j=0 时，\textit{dp}[i][0]=\textit{dp}[i-1][0]+\textit{grid}[i][0]dp[i][0]=dp[i−1][0]+grid[i][0]。
     *
     * 当 i=0i=0 且 j>0j>0 时，\textit{dp}[0][j]=\textit{dp}[0][j-1]+\textit{grid}[0][j]dp[0][j]=dp[0][j−1]+grid[0][j]。
     *
     * 当 i>0i>0 且 j>0j>0 时，\textit{dp}[i][j]=\min(\textit{dp}[i-1][j],\textit{dp}[i][j-1])+\textit{grid}[i][j]dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
     *
     * 最后得到 \textit{dp}[m-1][n-1]dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和。
     *
     *
     * 1 / 17
     *
     * JavaC++GolangPython3C
     *
     * class Solution {
     *     public int minPathSum(int[][] grid) {
     *         if (grid == null || grid.length == 0 || grid[0].length == 0) {
     *             return 0;
     *         }
     *         int rows = grid.length, columns = grid[0].length;
     *         int[][] dp = new int[rows][columns];
     *         dp[0][0] = grid[0][0];
     *         for (int i = 1; i < rows; i++) {
     *             dp[i][0] = dp[i - 1][0] + grid[i][0];
     *         }
     *         for (int j = 1; j < columns; j++) {
     *             dp[0][j] = dp[0][j - 1] + grid[0][j];
     *         }
     *         for (int i = 1; i < rows; i++) {
     *             for (int j = 1; j < columns; j++) {
     *                 dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
     *             }
     *         }
     *         return dp[rows - 1][columns - 1];
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是网格的行数和列数。需要对整个网格遍历一次，计算 \textit{dp}dp 的每个元素的值。
     *
     * 空间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是网格的行数和列数。创建一个二维数组 dpdp，和网格大小相同。
     * 空间复杂度可以优化，例如每次只存储上一行的 \textit{dp}dp 值，则可以将空间复杂度优化到 O(n)O(n)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
