package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/31 12:33 上午
 * @Email 794763733@qq.com
 */
public class 键盘行 {
    private static final String[] board = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<String>();
        X:
        for (String word : words) {
            String temp = word.toLowerCase();
            char ch = temp.charAt(0);
            String str = board[0].indexOf(ch) != -1 ? board[0] : board[1].indexOf(ch) != -1 ? board[1] : board[2];
            for (int i = 1; i < temp.length(); i++) {
                if (str.indexOf(temp.charAt(i)) == -1) {
                    continue X;
                }
            }
            list.add(word);
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
