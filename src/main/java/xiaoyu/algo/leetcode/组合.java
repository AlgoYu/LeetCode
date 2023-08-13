package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 组合 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    private void dfs(int n, int k, int number) {
        if (list.size() + (n - number + 1) < k) {
            return;
        }
        if (list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        list.add(number);
        dfs(n, k, number + 1);
        list.removeLast();
        dfs(n, k, number + 1);
    }
}
