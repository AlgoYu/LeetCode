package xiaoyu.algo.leetcode;

public class 判断国际象棋棋盘中一个格子的颜色 {
    public static void main(String[] args) {
        判断国际象棋棋盘中一个格子的颜色 test = new 判断国际象棋棋盘中一个格子的颜色();
        test.squareIsWhite("a1");
    }

    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(0) - 'a' + 1;
        int col = coordinates.charAt(1) - '0';
        boolean bool = (row & 1) != 1;
        if (col > 1 && (col & 1) == 0) {
            bool = !bool;
        }
        return bool;
    }
}