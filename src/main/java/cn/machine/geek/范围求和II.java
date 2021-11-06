package cn.machine.geek;

public class 范围求和II {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int row = m;
        int column = n;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] == 0 || ops[i][1] == 0) {
                continue;
            }
            row = Math.min(row, ops[i][0]);
            column = Math.min(column, ops[i][1]);
        }
        return row * column;
    }
}
