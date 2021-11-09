package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 祖玛游戏 {
    public static void main(String[] args) {
        祖玛游戏 test = new 祖玛游戏();
        System.out.println(test.findMinStep("RRWWRRW", "WR"));
    }

    int min = Integer.MAX_VALUE;

    public int findMinStep(String board, String hand) {
        Map<Character, Integer> hands = new HashMap<>();
        for (int i = 0; i < hand.length(); i++) {
            char ch = hand.charAt(i);
            hands.put(ch, hands.getOrDefault(ch, 0) + 1);
        }
        backtrack(new StringBuilder(board), hands, hand.length(), 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void backtrack(StringBuilder sb, Map<Character, Integer> hands, int n, int step) {
        // 所有彩球清理完了
        if (sb.length() == 0) {
            min = Math.min(min, step);
            return;
        }
        // 剪枝，手中球用完。
        if (n == 0) {
            return;
        }
        //
        int index = 0;
        while (index < sb.length()) {
            StringBuilder backup = new StringBuilder(sb);
            // 当前位置的彩球
            char ch = backup.charAt(index);
            Integer num = hands.getOrDefault(ch, 0);
            if (num > 0) {
                // 使用相同
                backup.insert(index, ch);
                hands.put(ch, num - 1);
                backtrack(merge(backup), hands, n - 1, step + 1);
                hands.put(ch, num);
                // 剪枝，重复彩球
                while (index + 1 < sb.length() && sb.charAt(index + 1) == ch) {
                    index++;
                }
            } else {
                // 全部尝试
                for (Map.Entry<Character, Integer> hand : hands.entrySet()) {
                    if (hand.getValue() <= 0) {
                        continue;
                    }
                    StringBuilder temp = new StringBuilder(sb);
                    temp.insert(index, hand.getKey());
                    hand.setValue(hand.getValue() - 1);
                    backtrack(merge(temp), hands, n - 1, step + 1);
                    hand.setValue(hand.getValue() + 1);
                }
            }
            index++;
        }
    }

    /**
     * 消除彩球
     *
     * @param board
     * @return
     */
    private StringBuilder merge(StringBuilder board) {
        if (board.length() < 3) {
            return board;
        }
        int n = board.length();
        boolean flag = false;
        for (int i = 0; i < n - 2; i++) {
            if (board.charAt(i) == board.charAt(i + 1) && board.charAt(i) == board.charAt(i + 2)) {
                flag = true;
                int end = i + 2;
                while (end < n && board.charAt(i) == board.charAt(end)) {
                    end++;
                }
                board.delete(i, end);
                break;
            }
        }
        return flag ? merge(board) : board;
    }
}
