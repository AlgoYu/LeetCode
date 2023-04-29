package xiaoyu.algo.leetcode;

import java.util.Objects;
import java.util.Stack;

public class 简化路径 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        int n = path.length();
        while (index < n) {
            int k = index;
            while (k < n && path.charAt(k) != '/') {
                k++;
            }
            if (index == k) {
                index++;
                continue;
            }
            String name = path.substring(index, k);
            if (Objects.equals(name, ".")) {

            } else if (Objects.equals(name, "..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(name);
            }
            index = k + 1;
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}
