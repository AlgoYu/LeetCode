package xiaoyu.algo.leetcode;

import java.util.Stack;

public class 基本计算器II {
    public int calculate(String s) {
        int index = 0, result = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }
            if (Character.isDigit(s.charAt(index))) {
                int n = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    n = n * 10 + (s.charAt(index) - '0');
                    index++;
                }

                if (operator.isEmpty()) {
                    stack.push(n);
                } else {
                    switch (operator.peek()) {
                        case '+':
                            stack.push(n);
                            break;
                        case '-':
                            stack.push(-n);
                            break;
                        case '*':
                            stack.push(stack.pop() * n);
                            break;
                        case '/':
                            stack.push(stack.pop() / n);
                            break;
                    }
                }
            } else {
                operator.push(s.charAt(index));
                index++;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
