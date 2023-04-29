package xiaoyu.algo.leetcode;

import java.util.Stack;

public class 括号的分数 {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        if (n == 2) {
            return 1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                top = stack.pop() + Math.max(top * 2, 1);
                stack.push(top);
            }
        }
        return stack.peek();
    }
}
