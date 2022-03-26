package cn.machine.geek;

import java.util.Stack;

public class 棒球比赛 {
    public int calPoints(String[] ops) {
        int n = ops.length;
        int total = 0;
        if (n == 0) {
            return total;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String op = ops[i];
            int cur = 0;
            switch (op) {
                case "+":
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2);
                    stack.push(num1);
                    cur = num1 + num2;
                    stack.push(cur);
                    break;
                case "D":
                    cur = stack.peek() * 2;
                    stack.push(cur);
                    break;
                case "C":
                    cur = stack.pop();
                    cur = -cur;
                    break;
                default:
                    cur = Integer.parseInt(op);
                    stack.push(cur);
                    break;
            }
            total += cur;
        }
        return total;
    }
}
