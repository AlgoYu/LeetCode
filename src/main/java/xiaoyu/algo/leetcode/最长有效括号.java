package xiaoyu.algo.leetcode;

import java.util.Stack;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/11 3:14 下午
 * @Email 794763733@qq.com
 */
public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            stack.pop();
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
