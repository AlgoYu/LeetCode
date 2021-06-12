package cn.machine.geek;

/**
 * 单词搜索
 * 难度
 * 中等
 * <p>
 * 824
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, int row, int column, int index, String word) {
        if (board[row][column] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return board[row][column] == word.charAt(index);
        }
        visited[row][column] = true;
        boolean flag = false;
        if (row - 1 >= 0 && !visited[row - 1][column]) {
            flag = search(board, visited, row - 1, column, index + 1, word);
        }
        if (flag) {
            return flag;
        }
        if (row + 1 < board.length && !visited[row + 1][column]) {
            flag = search(board, visited, row + 1, column, index + 1, word);
        }
        if (flag) {
            return flag;
        }
        if (column - 1 >= 0 && !visited[row][column - 1]) {
            flag = search(board, visited, row, column - 1, index + 1, word);
        }
        if (flag) {
            return flag;
        }
        if (column + 1 < board[0].length && !visited[row][column + 1]) {
            flag = search(board, visited, row, column + 1, index + 1, word);
        }
        if (flag) {
            return flag;
        }
        visited[row][column] = false;
        return false;
    }
    /**
     * 方法一：深度优先搜索
     *
     * 思路与算法
     *
     * 设函数
     * check
     * (
     * i
     * ,
     * j
     * ,
     * k
     * )
     * check(i,j,k) 判断以网格的
     * (
     * i
     * ,
     * j
     * )
     * (i,j) 位置出发，能否搜索到单词
     * word
     * [
     * k
     * .
     * .
     * ]
     * word[k..]，其中
     * word
     * [
     * k
     * .
     * .
     * ]
     * word[k..] 表示字符串
     * word
     * word 从第
     * k
     * k 个字符开始的后缀子串。如果能搜索到，则返回
     * true
     * true，反之返回
     * false
     * false。函数
     * check
     * (
     * i
     * ,
     * j
     * ,
     * k
     * )
     * check(i,j,k) 的执行步骤如下：
     *
     * 如果
     * board
     * [
     * i
     * ]
     * [
     * j
     * ]
     * ≠
     * s
     * [
     * k
     * ]
     * board[i][j]
     * 
     * ​
     *  =s[k]，当前字符不匹配，直接返回
     * false
     * false。
     * 如果当前已经访问到字符串的末尾，且对应字符依然匹配，此时直接返回
     * true
     * true。
     * 否则，遍历当前位置的所有相邻位置。如果从某个相邻位置出发，能够搜索到子串
     * word
     * [
     * k
     * +
     * 1..
     * ]
     * word[k+1..]，则返回
     * true
     * true，否则返回
     * false
     * false。
     * 这样，我们对每一个位置
     * (
     * i
     * ,
     * j
     * )
     * (i,j) 都调用函数
     * check
     * (
     * i
     * ,
     * j
     * ,
     * 0
     * )
     * check(i,j,0) 进行检查：只要有一处返回
     * true
     * true，就说明网格中能够找到相应的单词，否则说明不能找到。
     *
     * 为了防止重复遍历相同的位置，需要额外维护一个与
     * board
     * board 等大的
     * visited
     * visited 数组，用于标识每个位置是否被访问过。每次遍历相邻位置时，需要跳过已经被访问的位置。
     *
     * 代码
     *
     * C++JavaPython3JavaScriptGolangC
     *
     * class Solution {
     *     public boolean exist(char[][] board, String word) {
     *         int h = board.length, w = board[0].length;
     *         boolean[][] visited = new boolean[h][w];
     *         for (int i = 0; i < h; i++) {
     *             for (int j = 0; j < w; j++) {
     *                 boolean flag = check(board, visited, i, j, word, 0);
     *                 if (flag) {
     *                     return true;
     *                 }
     *             }
     *         }
     *         return false;
     *     }
     *
     *     public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
     *         if (board[i][j] != s.charAt(k)) {
     *             return false;
     *         } else if (k == s.length() - 1) {
     *             return true;
     *         }
     *         visited[i][j] = true;
     *         int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
     *         boolean result = false;
     *         for (int[] dir : directions) {
     *             int newi = i + dir[0], newj = j + dir[1];
     *             if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
     *                 if (!visited[newi][newj]) {
     *                     boolean flag = check(board, visited, newi, newj, s, k + 1);
     *                     if (flag) {
     *                         result = true;
     *                         break;
     *                     }
     *                 }
     *             }
     *         }
     *         visited[i][j] = false;
     *         return result;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：一个非常宽松的上界为
     * O
     * (
     * M
     * N
     * ⋅
     * 3
     * L
     * )
     * O(MN⋅3
     * L
     *  )，其中
     * M
     * ,
     * N
     * M,N 为网格的长度与宽度，
     * L
     * L 为字符串
     * word
     * word 的长度。在每次调用函数
     * check
     * check 时，除了第一次可以进入
     * 4
     * 4 个分支以外，其余时间我们最多会进入
     * 3
     * 3 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。由于单词长为
     * L
     * L，故
     * check(i, j, 0)
     * check(i, j, 0) 的时间复杂度为
     * O
     * (
     * 3
     * L
     * )
     * O(3
     * L
     *  )，而我们要执行
     * O
     * (
     * M
     * N
     * )
     * O(MN) 次检查。然而，由于剪枝的存在，我们在遇到不匹配或已访问的字符时会提前退出，终止递归流程。因此，实际的时间复杂度会远远小于
     * Θ
     * (
     * M
     * N
     * ⋅
     * 3
     * L
     * )
     * Θ(MN⋅3
     * L
     *  )。
     * 空间复杂度：
     * O
     * (
     * M
     * N
     * )
     * O(MN)。我们额外开辟了
     * O
     * (
     * M
     * N
     * )
     * O(MN) 的
     * visited
     * visited 数组，同时栈的深度最大为
     * O
     * (
     * min
     * ⁡
     * (
     * L
     * ,
     * M
     * N
     * )
     * )
     * O(min(L,MN))。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-search/solution/dan-ci-sou-suo-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
