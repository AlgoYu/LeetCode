package cn.machine.geek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class 组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 1) {
            result.add(Collections.singletonList(1));
            return result;
        }
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int index, int n, int k) {
        if (n - index + 1 + list.size() < k) {
            return;
        }
        // 已经满足
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 选
        list.add(index);
        dfs(result, list, index + 1, n, k);
        list.remove(list.size() - 1);
        // 不选
        dfs(result, list, index + 1, n, k);
    }
}
