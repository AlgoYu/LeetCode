package xiaoyu.algo.leetcode;

import java.util.*;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        /*Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        return set.size() < nums.length;*/
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

    /**
     * 方法一：朴素线性查找 【超时】
     * 直觉
     * <p>
     * 对于一个有 nn 个整数的数组，一共有 C(n,2) = \frac{n(n+1)}{2}C(n,2)=
     * 2
     * n(n+1)
     * ​
     * 对整数。因此，我们可以对所有的 \frac{n(n+1)}{2}
     * 2
     * n(n+1)
     * ​
     * 对进行检测，看它们是否相同。
     * <p>
     * 算法
     * <p>
     * 为了实现这个思路，我们使用线性查找算法，这是最简单的查找算法。线性查找是一种检查特定值是否在列表中的算法，做法是依次逐个检查列表中的元素，直到找到满足的元素。
     * <p>
     * 对于本问题，我们循环遍历全部 nn 个数。对于第 ii 个整数 nums[i]，我们对前 i-1 个整数查找 nums[i] 的重复值。若找到，则返回 True; 否则继续。在程序最后，返回 False。
     * <p>
     * 为了证明算法的正确性，我们定义了循环不变式。循环不变式是指在每次迭代前和后均保持不变的性质。了解循环不变式对理解循环的意义十分重要。下面就是循环不变式:
     * <p>
     * 在下一次搜索之前,搜索过的整数中没有重复的整数。
     * <p>
     * 循环不变式在循环之前为真，因为还没有搜索过的整数。每次循环，我们查找当前元素的任何可能重复。如果发现重复项,则函数返回 True 退出；如果没有发现，则不变式仍然成立。
     * <p>
     * 因此，如果循环结束，循环不变式说明全部 nn 个整数中不存在重复元素。
     * <p>
     * Java
     * <p>
     * public boolean containsDuplicate(int[] nums) {
     * for (int i = 0; i < nums.length; ++i) {
     * for (int j = 0; j < i; ++j) {
     * if (nums[j] == nums[i]) return true;
     * }
     * }
     * return false;
     * }
     * // Time Limit Exceeded
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(n^2)O(n
     * 2
     * )。最坏的情况下，需要检查 \frac{n(n+1)}{2}
     * 2
     * n(n+1)
     * ​
     * 对整数。因此，时间复杂度为 O(n^2)O(n
     * 2
     * )。
     * <p>
     * 空间复杂度 : O(1)O(1)。只使用了常数额外空间。
     * <p>
     * 注意
     * <p>
     * 本方法在 Leetcode 上会超时。一般而言，如果一个算法的时间复杂度为 O(n^2)O(n
     * 2
     * )，它最多能处理 nn 大约为 10^410
     * 4
     * 的数据。当 nn 接近 10^510
     * 5
     * 时就会超时。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateOfficial1(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }

    /**
     * 方法二：排序 【通过】
     * 直觉
     * <p>
     * 如果存在重复元素，排序后它们应该相邻。
     * <p>
     * 算法
     * <p>
     * 本方法使用排序算法。由于比较排序算法，如堆排序，可以在最坏情况下具有 O(n \log n)O(nlogn) 的时间复杂度。因此，排序经常是很好的预处理方法。排序之后，我们可以扫描已排序的数组,以查找是否有任何连续的重复元素。
     * <p>
     * Java
     * <p>
     * public boolean containsDuplicate(int[] nums) {
     * Arrays.sort(nums);
     * for (int i = 0; i < nums.length - 1; ++i) {
     * if (nums[i] == nums[i + 1]) return true;
     * }
     * return false;
     * }
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(n \log n)O(nlogn)。
     * 排序的复杂度是 O(n \log n)O(nlogn)，扫描的复杂度是 O(n)O(n)。整个算法主要由排序过程决定，因此是 O(n \log n)O(nlogn)。
     * <p>
     * 空间复杂度 : O(1)O(1)。
     * 这取决于具体的排序算法实现，通常而言，使用 堆排序 的话，是 O(1)O(1)。
     * <p>
     * 注意
     * <p>
     * 此处的算法实现对原始数组进行排序，修改了原始数组。通常，除非调用方清楚输入数据将被修改，否则不应该随意修改输入数据。可以先复制 nums，然后对副本进行操作。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateOfficial2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    /**
     * 方法三：哈希表 【通过】
     * 直觉
     * <p>
     * 利用支持快速搜索和插入操作的动态数据结构。
     * <p>
     * 算法
     * <p>
     * 从方法一中我们知道，对无序数组的查找操作的时间复杂度为 O(n)O(n)，而我们会重复调用查找操作。因此，使用搜索时间更快的数据结构将加快整个算法的速度。
     * <p>
     * 有许多数据结构常用作动态集合,如二进制搜索树和哈希表。这里我们需要的操作是 search 和 insert。对于平衡二叉搜索树（Java 中的 TreeSet 或 TreeMap），search 和 insert 的时间复杂度均为 O(\log n)O(logn)。对于哈希表（Java 中的 HashSet 或 HashMap），search 和 insert 的平均时间复杂度为 O(1)O(1)。因此，通过使用哈希表，我们可以达到在线性时间复杂度解决问题。
     * <p>
     * Java
     * <p>
     * public boolean containsDuplicate(int[] nums) {
     * Set<Integer> set = new HashSet<>(nums.length);
     * for (int x: nums) {
     * if (set.contains(x)) return true;
     * set.add(x);
     * }
     * return false;
     * }
     * 复杂度分析
     * <p>
     * 时间复杂度 : O(n)O(n)。
     * search() 和 insert() 各自使用 nn 次，每个操作耗费常数时间。
     * <p>
     * 空间复杂度 : O(n)O(n)。哈希表占用的空间与元素数量是线性关系。
     * <p>
     * 注意
     * <p>
     * 对于一些特定的 nn 不太大的测试样例，本方法的运行速度可能会比方法二更慢。这是因为哈希表在维护其属性时有一些开销。要注意，程序的实际运行表现和 Big-O 符号表示可能有所不同。Big-O 只是告诉我们在 充分 大的输入下，算法的相对快慢。因此，在 nn 不够大的情况下， O(n)O(n) 的算法也可以比 O(n \log n)O(nlogn)的更慢。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateOfficial3(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
