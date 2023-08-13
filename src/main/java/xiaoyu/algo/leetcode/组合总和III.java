package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合总和III {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return result;
    }

    private void backtrack(int k, int n, int num, int total) {
        if (list.size() > k || total > n || list.size() + (9 - num + 1) < k) {
            return;
        }
        if (total == n && list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        list.add(num);
        backtrack(k, n, num + 1, total + num);
        list.removeLast();
        backtrack(k, n, num + 1, total);
    }
}
