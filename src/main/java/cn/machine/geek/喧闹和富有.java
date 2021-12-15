package cn.machine.geek;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 喧闹和富有 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < richer.length; i++) {
            int rich = richer[i][0];
            int poor = richer[i][1];
            graph[poor].add(rich);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; ++i) {
            dfs(i, quiet, graph, ans);
        }
        return ans;
    }

    private void dfs(int i, int[] quiet, List<Integer>[] graph, int[] ans) {
        if (ans[i] != -1) {
            return;
        }
        ans[i] = i;
        for (Integer target : graph[i]) {
            dfs(target, quiet, graph, ans);
            if (quiet[ans[target]] < quiet[ans[i]]) {
                ans[i] = ans[target];
            }
        }
    }
}
