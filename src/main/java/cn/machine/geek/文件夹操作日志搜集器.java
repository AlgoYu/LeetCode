package cn.machine.geek;

import java.util.Stack;

public class 文件夹操作日志搜集器 {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            switch (log) {
                case "../":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "./":
                    break;
                default:
                    stack.push(log.replace("/", ""));
                    break;
            }
        }
        return stack.size();
    }
}
