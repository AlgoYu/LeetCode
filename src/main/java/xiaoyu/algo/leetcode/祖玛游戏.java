package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 祖玛游戏 {
    int INF = 0x3f3f3f3f;
    String hand;
    int m;
    Map<String, Integer> map = new HashMap<>();

    public int findMinStep(String a, String hand) {
        this.hand = hand;
        m = this.hand.length();
        int ans = dfs(a, 1 << m);
        return ans == INF ? -1 : ans;
    }

    int dfs(String a, int cur) {
        if (a.length() == 0) return 0;
        if (map.containsKey(a)) return map.get(a);
        int ans = INF;
        int n = a.length();
        for (int i = 0; i < m; i++) {
            if (((cur >> i) & 1) == 1) continue;
            int next = (1 << i) | cur;
            for (int j = 0; j <= n; j++) {
                boolean ok = true;
                if (j > 0 && j < n && a.charAt(j) == a.charAt(j - 1) && a.charAt(j - 1) != hand.charAt(i)) ok = false;
                if (j < n && a.charAt(j) == hand.charAt(i)) ok = false;
                if (ok) continue;
                StringBuilder sb = new StringBuilder(a);
                sb.insert(j, hand.charAt(i));
                ans = Math.min(ans, dfs(merge(sb), next) + 1);
            }
        }
        map.put(a, ans);
        return ans;
    }

    /**
     * 消除彩球
     *
     * @param board
     * @return
     */
    private String merge(StringBuilder board) {
        if (board.length() < 3) {
            return board.toString();
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
        return flag ? merge(board) : board.toString();
    }
}
