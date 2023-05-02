package xiaoyu.algo.leetcode;

import java.util.Stack;

public class 检查替换后的词是否有效 {
    public boolean isValid(String s) {
        if (s.length() % 3 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= 3 && stack.peek() == 'c') {
                if (stack.pop() != 'c' || stack.pop() != 'b' || stack.pop() != 'a') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
