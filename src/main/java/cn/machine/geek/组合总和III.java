package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {

    boolean[] data;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        data = new boolean[9];
        backtrack(result, 1, 9, k, n, new ArrayList<>(k));
        return result;
    }

    private void backtrack(List<List<Integer>> result, int cur, int max, int k, int n, ArrayList<Integer> list) {
        if (list.size() + (max - cur + 1) < k || list.size() > k) {
            return;
        }
        if (list.size() == k) {
            if (n != 0) {
                return;
            }
            result.add(new ArrayList<>(list));
            return;
        }
        if (n >= cur) {
            list.add(cur);
            backtrack(result, cur + 1, max, k, n - cur, list);
            list.remove(list.size() - 1);
        }
        backtrack(result, cur + 1, max, k, n, list);
    }
}
