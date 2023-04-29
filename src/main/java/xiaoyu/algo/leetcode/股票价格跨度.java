package xiaoyu.algo.leetcode;

import java.util.Stack;

public class 股票价格跨度 {
    Stack<int[]> stack;
    int index;

    public 股票价格跨度() {
        stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE, -1});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (stack.peek()[0] <= price) {
            stack.pop();
        }
        int result = index - stack.peek()[1];
        stack.push(new int[]{price, index});
        return result;
    }
}