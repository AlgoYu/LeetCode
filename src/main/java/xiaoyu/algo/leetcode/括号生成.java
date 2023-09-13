package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result, new StringBuilder(), n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder stringBuilder, int n) {
        if (stringBuilder.length() == n * 2) {
            if (isValid(stringBuilder)) {
                result.add(stringBuilder.toString());
            }
            return;
        }
        stringBuilder.append("(");
        backtrack(result, stringBuilder, n);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        backtrack(result, stringBuilder, n);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    private boolean isValid(StringBuilder stringBuilder) {
        int l = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '(') {
                l++;
            } else {
                l--;
                if (l < 0) {
                    return false;
                }
            }
        }
        return l == 0;
    }
}
