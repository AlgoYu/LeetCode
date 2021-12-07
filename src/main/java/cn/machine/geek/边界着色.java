package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 边界着色 {
    // [1,2,1,2,1,2],
    // [2,2,2,2,1,2],
    // [1,2,2,2,1,2]
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, col));
        List<Node> list = new LinkedList<>();
        int replace = grid[row][col];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int tRow = node.row;
            int tCol = node.col;
            if (isValid(grid.length, grid[0].length, tRow - 1, tCol) && grid[tRow - 1][tCol] == replace && !visited[tRow - 1][tCol]) {
                queue.add(new Node(tRow - 1, tCol));
            }
            if (isValid(grid.length, grid[0].length, tRow + 1, tCol) && grid[tRow + 1][tCol] == replace && !visited[tRow + 1][tCol]) {
                queue.add(new Node(tRow + 1, tCol));
            }
            if (isValid(grid.length, grid[0].length, tRow, tCol - 1) && grid[tRow][tCol - 1] == replace && !visited[tRow][tCol - 1]) {
                queue.add(new Node(tRow, tCol - 1));
            }
            if (isValid(grid.length, grid[0].length, tRow, tCol + 1) && grid[tRow][tCol + 1] == replace && !visited[tRow][tCol + 1]) {
                queue.add(new Node(tRow, tCol + 1));
            }
            visited[tRow][tCol] = true;
            if (isBounds(grid.length, grid[0].length, tRow, tCol) || isColorBounds(grid, tRow, tCol, replace)) {
                list.add(node);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            grid[node.row][node.col] = color;
        }
        return grid;
    }

    private boolean isValid(int row, int colum, int curRow, int curColum) {
        return curRow >= 0 && curRow < row && curColum >= 0 && curColum < colum;
    }

    private boolean isBounds(int row, int colum, int curRow, int curColum) {
        return curRow == 0 || curColum == 0 || curRow + 1 == row || curColum + 1 == colum;
    }

    private boolean isColorBounds(int[][] grid, int row, int colum, int color) {
        return grid[row - 1][colum] != color || grid[row + 1][colum] != color || grid[row][colum - 1] != color || grid[row][colum + 1] != color;
    }

    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
