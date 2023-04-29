package xiaoyu.algo.leetcode;

import java.util.HashMap;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) (num) - (int) ('0');
                    row[i][n - 1]++;
                    column[j][n - 1]++;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    box[boxIndex][n - 1]++;
                    if (row[i][n - 1] > 1 || column[j][n - 1] > 1 || box[boxIndex][n - 1] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 思路
     * 一个简单的解决方案是遍历该 9 x 9 数独 三 次，以确保：
     * <p>
     * 行中没有重复的数字。
     * 列中没有重复的数字。
     * 3 x 3 子数独内没有重复的数字。
     * 实际上，所有这一切都可以在一次迭代中完成。
     * <p>
     * 方法：一次迭代
     * 首先，让我们来讨论下面两个问题：
     * <p>
     * 如何枚举子数独？
     * 可以使用 box_index = (row / 3) * 3 + columns / 3，其中 / 是整数除法。
     * <p>
     * <p>
     * <p>
     * 如何确保行 / 列 / 子数独中没有重复项？
     * 可以利用 value -> count 哈希映射来跟踪所有已经遇到的值。
     * <p>
     * 现在，我们完成了这个算法的所有准备工作：
     * <p>
     * 遍历数独。
     * 检查看到每个单元格值是否已经在当前的行 / 列 / 子数独中出现过：
     * 如果出现重复，返回 false。
     * 如果没有，则保留此值以进行进一步跟踪。
     * 返回 true。
     * <p>
     * 1 / 15
     * <p>
     * JavaPython
     * <p>
     * class Solution {
     * public boolean isValidSudoku(char[][] board) {
     * // init data
     * HashMap<Integer, Integer> [] rows = new HashMap[9];
     * HashMap<Integer, Integer> [] columns = new HashMap[9];
     * HashMap<Integer, Integer> [] boxes = new HashMap[9];
     * for (int i = 0; i < 9; i++) {
     * rows[i] = new HashMap<Integer, Integer>();
     * columns[i] = new HashMap<Integer, Integer>();
     * boxes[i] = new HashMap<Integer, Integer>();
     * }
     * <p>
     * // validate a board
     * for (int i = 0; i < 9; i++) {
     * for (int j = 0; j < 9; j++) {
     * char num = board[i][j];
     * if (num != '.') {
     * int n = (int)num;
     * int box_index = (i / 3 ) * 3 + j / 3;
     * <p>
     * // keep the current cell value
     * rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
     * columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
     * boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
     * <p>
     * // check if this value has been already seen before
     * if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
     * return false;
     * }
     * }
     * }
     * <p>
     * return true;
     * }
     * }
     * 复杂度分析
     * <p>
     * 时间复杂度：O(1)O(1)，因为我们只对 81 个单元格进行了一次迭代。
     * 空间复杂度：O(1)O(1)。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param board
     * @return
     */
    public boolean isValidSudokuOfficial(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}
