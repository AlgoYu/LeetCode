package cn.machine.geek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class 子集II {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }
    /**
     * 前言
     * 本题解基于「78. 子集的官方题解」，请读者在充分理解该题解后继续阅读。
     *
     * 方法一：迭代法实现子集枚举
     * 思路
     *
     * 考虑数组 [1,2,2][1,2,2]，选择前两个数，或者第一、三个数，都会得到相同的子集。
     *
     * 也就是说，对于当前选择的数 xx，若前面有与其相同的数 yy，且没有选择 yy，此时包含 xx 的子集，必然会出现在包含 yy 的所有子集中。
     *
     * 我们可以通过判断这种情况，来避免生成重复的子集。代码实现时，可以先将数组排序；迭代时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
     *
     * 代码
     *
     * C++JavaGolangJavaScriptC
     *
     * class Solution {
     *     List<Integer> t = new ArrayList<Integer>();
     *     List<List<Integer>> ans = new ArrayList<List<Integer>>();
     *
     *     public List<List<Integer>> subsetsWithDup(int[] nums) {
     *         Arrays.sort(nums);
     *         int n = nums.length;
     *         for (int mask = 0; mask < (1 << n); ++mask) {
     *             t.clear();
     *             boolean flag = true;
     *             for (int i = 0; i < n; ++i) {
     *                 if ((mask & (1 << i)) != 0) {
     *                     if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
     *                         flag = false;
     *                         break;
     *                     }
     *                     t.add(nums[i]);
     *                 }
     *             }
     *             if (flag) {
     *                 ans.add(new ArrayList<Integer>(t));
     *             }
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n \times 2^n)O(n×2
     * n
     *  )，其中 nn 是数组 \textit{nums}nums 的长度。排序的时间复杂度为 O(n \log n)O(nlogn)。一共 2^n2
     * n
     *   个状态，每种状态需要 O(n)O(n) 的时间来构造子集，一共需要 O(n \times 2^n)O(n×2
     * n
     *  ) 的时间来构造子集。由于在渐进意义上 O(n \log n)O(nlogn) 小于 O(n \times 2^n)O(n×2
     * n
     *  )，故总的时间复杂度为 O(n \times 2^n)O(n×2
     * n
     *  )。
     *
     * 空间复杂度：O(n)O(n)。即构造子集使用的临时数组 tt 的空间代价。
     *
     * 方法二：递归法实现子集枚举
     * 思路
     *
     * 与方法一类似，在递归时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
     *
     * 代码
     *
     * C++JavaGolangJavaScript
     *
     * class Solution {
     *     List<Integer> t = new ArrayList<Integer>();
     *     List<List<Integer>> ans = new ArrayList<List<Integer>>();
     *
     *     public List<List<Integer>> subsetsWithDup(int[] nums) {
     *         Arrays.sort(nums);
     *         dfs(false, 0, nums);
     *         return ans;
     *     }
     *
     *     public void dfs(boolean choosePre, int cur, int[] nums) {
     *         if (cur == nums.length) {
     *             ans.add(new ArrayList<Integer>(t));
     *             return;
     *         }
     *         dfs(false, cur + 1, nums);
     *         if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
     *             return;
     *         }
     *         t.add(nums[cur]);
     *         dfs(true, cur + 1, nums);
     *         t.remove(t.size() - 1);
     *     }
     * }
     * C
     *
     * int cmp(int* a, int* b) {
     *     return *a - *b;
     * }
     *
     * int* t;
     * int tSize;
     *
     * void dfs(bool choosePre, int cur, int* nums, int numSize, int** ret, int* returnSize, int** returnColumnSizes) {
     *     if (cur == numSize) {
     *         int* tmp = malloc(sizeof(int) * tSize);
     *         memcpy(tmp, t, sizeof(int) * tSize);
     *         ret[*returnSize] = tmp;
     *         (*returnColumnSizes)[(*returnSize)++] = tSize;
     *         return;
     *     }
     *     dfs(false, cur + 1, nums, numSize, ret, returnSize, returnColumnSizes);
     *     if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
     *         return;
     *     }
     *     t[tSize++] = nums[cur];
     *     dfs(true, cur + 1, nums, numSize, ret, returnSize, returnColumnSizes);
     *     tSize--;
     * }
     *
     * int** subsetsWithDup(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
     *     qsort(nums, numsSize, sizeof(int), cmp);
     *     int n = numsSize;
     *     *returnSize = 0;
     *     *returnColumnSizes = malloc(sizeof(int) * (1 << n));
     *     int** ret = malloc(sizeof(int*) * (1 << n));
     *     t = malloc(sizeof(int) * n);
     *     dfs(false, 0, nums, n, ret, returnSize, returnColumnSizes);
     *     return ret;
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n \times 2^n)O(n×2
     * n
     *  )，其中 nn 是数组 \textit{nums}nums 的长度。排序的时间复杂度为 O(n \log n)O(nlogn)。最坏情况下 \textit{nums}nums 中无重复元素，需要枚举其所有 2^n2
     * n
     *   个子集，每个子集加入答案时需要拷贝一份，耗时 O(n)O(n)，一共需要 O(n \times 2^n)+O(n)=O(n \times 2^n)O(n×2
     * n
     *  )+O(n)=O(n×2
     * n
     *  ) 的时间来构造子集。由于在渐进意义上 O(n \log n)O(nlogn) 小于 O(n \times 2^n)O(n×2
     * n
     *  )，故总的时间复杂度为 O(n \times 2^n)O(n×2
     * n
     *  )。
     *
     * 空间复杂度：O(n)O(n)。临时数组 \textit{t}t 的空间代价是 O(n)O(n)，递归时栈空间的代价为 O(n)O(n)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subsets-ii/solution/zi-ji-ii-by-leetcode-solution-7inq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
