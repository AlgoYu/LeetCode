package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/27 12:31 下午
 * @Email 794763733@qq.com
 */
public class 删除无效的括号 {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        List<String> backtrack = backtrack(s, new LinkedList<>(), new StringBuilder(), 0, 0);
        backtrack.sort((o1, o2) -> {
            return Math.abs(n - o1.length()) - Math.abs(n - o2.length());
        });
        List<String> result = new LinkedList<>();
        for (int i = 0; i < backtrack.size(); i++) {
            String s1 = backtrack.get(i);
            if (i > 0 && s1.length() != backtrack.get(i - 1).length()) {
                break;
            }
            result.add(s1);
        }
        return result;
    }

    private List<String> backtrack(String s, List<String> list, StringBuilder sb, int index, int flag) {
        if (index >= s.length()) {
            String str = sb.toString();
            if (flag == 0 && !list.contains(str)) {
                list.add(sb.toString());
            }
            return list;
        }
        char ch = s.charAt(index);
        if (ch >= 'a' && ch <= 'z') {
            sb.append(ch);
            backtrack(s, list, sb, index + 1, flag);
            sb.delete(sb.length() - 1, sb.length());
            return list;
        }
        // 删除当前
        backtrack(s, list, sb, index + 1, flag);
        // 不删除当前
        if (ch == '(') {
            flag++;
        } else {
            flag--;
        }
        if (flag < 0) {
            return list;
        }
        sb.append(ch);
        backtrack(s, list, sb, index + 1, flag);
        sb.delete(sb.length() - 1, sb.length());
        return list;
    }
}
