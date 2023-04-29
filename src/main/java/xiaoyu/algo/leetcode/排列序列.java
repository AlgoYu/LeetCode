package xiaoyu.algo.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 排列序列
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 示例 3：
 * <p>
 * 输入：n = 3, k = 1
 * 输出："123"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class 排列序列 {
    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
        }
        List<String> list = new LinkedList<>();
        perm(stringBuilder.toString().toCharArray(), list, 0, new StringBuilder());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list.get(k - 1);
    }

    private void perm(char[] chars, List<String> list, int index, StringBuilder com) {
        if (com.length() == chars.length) {
            list.add(com.toString());
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            com.append(chars[index]);
            perm(chars, list, index + 1, com);
            swap(chars, index, i);
            com.delete(index, index + 1);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    /**
     * public String getPermutation(int n, int k) {
     *         int[] factorial = new int[n];
     *         factorial[0] = 1;
     *         for (int i = 1; i < n; ++i) {
     *             factorial[i] = factorial[i - 1] * i;
     *         }
     *
     *         --k;
     *         StringBuffer ans = new StringBuffer();
     *         int[] valid = new int[n + 1];
     *         Arrays.fill(valid, 1);
     *         for (int i = 1; i <= n; ++i) {
     *             int order = k / factorial[n - i] + 1;
     *             for (int j = 1; j <= n; ++j) {
     *                 order -= valid[j];
     *                 if (order == 0) {
     *                     ans.append(j);
     *                     valid[j] = 0;
     *                     break;
     *                 }
     *             }
     *             k %= factorial[n - i];
     *         }
     *         return ans.toString();
     *     }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutation-sequence/solution/di-kge-pai-lie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
