package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 解析布尔表达式 {
    public static void main(String[] args) {
        解析布尔表达式 test = new 解析布尔表达式();
        test.parseBoolExpr("!(&(f,t))");
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Character> values = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '|' || c == '&' || c == '!') {
                operators.push(c);
            } else if (c == '(' || c == 't' || c == 'f') {
                values.push(c);
            } else if (c == ')') {
                Character operator = operators.pop();
                List<Character> curValues = new ArrayList<>();
                while (values.peek() != '(') {
                    curValues.add(values.pop());
                }
                values.pop();
                if (operator == '!') {
                    values.push(!(curValues.get(0) == 't') ? 't' : 'f');
                    continue;
                }
                boolean and = operator == '&';
                char curResult = curValues.get(0);
                for (int j = 1; j < curValues.size(); j++) {
                    if (and && curValues.get(j) == 'f') {
                        curResult = 'f';
                        break;
                    } else if (!and && curValues.get(j) == 't') {
                        curResult = 't';
                        break;
                    }
                }
                values.push(curResult);
            }
        }
        return values.pop() == 't';
    }
}