package cn.machine.geek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> count = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return count;
        }
        com(nums, 0, count, new HashSet<>());
        return count;
    }

    public void com(int[] nums, int start, List<List<Integer>> count, Set<List<Integer>> set) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            if (!set.contains(list)) {
                count.add(list);
                set.add(list);
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            com(nums, start + 1, count, set);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 思路和算法
     *
     * 此题是「46. 全排列」的进阶，序列中包含了重复的数字，要求我们返回不重复的全排列，那么我们依然可以选择使用搜索回溯的方法来做。
     *
     * 我们将这个问题看作有 nn 个排列成一行的空格，我们需要从左往右依次填入题目给定的 nn 个数，每个数只能使用一次。那么很直接的可以想到一种穷举的算法，即从左往右每一个位置都依此尝试填入一个数，看能不能填完这 nn 个空格，在程序中我们可以用「回溯法」来模拟这个过程。
     *
     * 我们定义递归函数 backtrack(idx, perm) 表示当前排列为 \textit{perm}perm，下一个待填入的位置是第 \textit{idx}idx 个位置（下标从 00 开始）。那么整个递归函数分为两个情况：
     *
     * 如果 \textit{idx}==nidx==n，说明我们已经填完了 nn 个位置，找到了一个可行的解，我们将 \textit{perm}perm 放入答案数组中，递归结束。
     * 如果 \textit{idx}<nidx<n，我们要考虑第 \textit{idx}idx 个位置填哪个数。根据题目要求我们肯定不能填已经填过的数，因此很容易想到的一个处理手段是我们定义一个标记数组 \textit{vis}vis 来标记已经填过的数，那么在填第 \textit{idx}idx 个数的时候我们遍历题目给定的 nn 个数，如果这个数没有被标记过，我们就尝试填入，并将其标记，继续尝试填下一个位置，即调用函数 backtrack(idx + 1, perm)。搜索回溯的时候要撤销该个位置填的数以及标记，并继续尝试其他没被标记过的数。
     * 但题目解到这里并没有满足「全排列不重复」 的要求，在上述的递归函数中我们会生成大量重复的排列，因为对于第 \textit{idx}idx 的位置，如果存在重复的数字 ii，我们每次会将重复的数字都重新填上去并继续尝试导致最后答案的重复，因此我们需要处理这个情况。
     *
     * 要解决重复问题，我们只要设定一个规则，保证在填第 \textit{idx}idx 个数的时候重复数字只会被填入一次即可。而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」，即如下的判断条件：
     *
     * C++
     *
     * if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
     *     continue;
     * }
     * 这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
     *
     * 假设我们有 33 个重复数排完序后相邻，那么我们一定保证每次都是拿从左往右第一个未被填过的数字，即整个数组的状态其实是保证了 [未填入，未填入，未填入] 到 [填入，未填入，未填入]，再到 [填入，填入，未填入]，最后到 [填入，填入，填入] 的过程的，因此可以达到去重的目标。
     *
     * 代码
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     boolean[] vis;
     *
     *     public List<List<Integer>> permuteUnique(int[] nums) {
     *         List<List<Integer>> ans = new ArrayList<List<Integer>>();
     *         List<Integer> perm = new ArrayList<Integer>();
     *         vis = new boolean[nums.length];
     *         Arrays.sort(nums);
     *         backtrack(nums, ans, 0, perm);
     *         return ans;
     *     }
     *
     *     public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
     *         if (idx == nums.length) {
     *             ans.add(new ArrayList<Integer>(perm));
     *             return;
     *         }
     *         for (int i = 0; i < nums.length; ++i) {
     *             if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
     *                 continue;
     *             }
     *             perm.add(nums[i]);
     *             vis[i] = true;
     *             backtrack(nums, ans, idx + 1, perm);
     *             vis[i] = false;
     *             perm.remove(idx);
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n\times n!)O(n×n!)，其中 nn 为序列的长度。
     *
     * 算法的复杂度首先受 backtrack 的调用次数制约，backtrack 的调用次数为 \sum_{k = 1}^{n}{P(n, k)}∑
     * k=1
     * n
     * ​
     *  P(n,k) 次，其中 P(n, k) = \frac{n!}{(n - k)!} = n (n - 1) ... (n - k + 1)P(n,k)=
     * (n−k)!
     * n!
     * ​
     *  =n(n−1)...(n−k+1)，该式被称作 n 的 k - 排列，或者部分排列。
     *
     * 而 \sum_{k = 1}^{n}{P(n, k)} = n! + \frac{n!}{1!} + \frac{n!}{2!} + \frac{n!}{3!} + ... + \frac{n!}{(n-1)!} < 2n! + \frac{n!}{2} + \frac{n!}{2^2} + \frac{n!}{2^{n-2}} < 3n!∑
     * k=1
     * n
     * ​
     *  P(n,k)=n!+
     * 1!
     * n!
     * ​
     *  +
     * 2!
     * n!
     * ​
     *  +
     * 3!
     * n!
     * ​
     *  +...+
     * (n−1)!
     * n!
     * ​
     *  <2n!+
     * 2
     * n!
     * ​
     *  +
     * 2
     * 2
     *
     * n!
     * ​
     *  +
     * 2
     * n−2
     *
     * n!
     * ​
     *  <3n!
     *
     * 这说明 backtrack 的调用次数是 O(n!)O(n!) 的。
     *
     * 而对于 backtrack 调用的每个叶结点（最坏情况下没有重复数字共 n!n! 个），我们需要将当前答案使用 O(n)O(n) 的时间复制到答案数组中，相乘得时间复杂度为 O(n \times n!)O(n×n!)。
     *
     * 因此时间复杂度为 O(n \times n!)O(n×n!)。
     *
     * 空间复杂度：O(n)O(n)。我们需要 O(n)O(n) 的标记数组，同时在递归的时候栈深度会达到 O(n)O(n)，因此总空间复杂度为 O(n + n)=O(2n)=O(n)O(n+n)=O(2n)=O(n)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
