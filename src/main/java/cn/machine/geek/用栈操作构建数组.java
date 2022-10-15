package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 用栈操作构建数组 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        for (int i = 0; i < target.length; i++) {
            int targetNum = target[i];
            while (targetNum != index) {
                stack.push(index);
                result.add("Push");
                index++;
            }
            while (!stack.isEmpty() && stack.peek() != target[Math.max(i - 1, 0)]) {
                stack.pop();
                result.add("Pop");
            }
            stack.push(index);
            result.add("Push");
            index = (index + 1) % (n + 1);
        }
        return result;
    }
}