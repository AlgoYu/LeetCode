package cn.machine.geek;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }
        int mi = m - 1;
        int ni = n - 1;
        int last = nums1.length - 1;
        while (ni >= 0) {
            if (mi >= 0 && nums1[mi] > nums2[ni]) {
                nums1[last--] = nums1[mi--];
            } else {
                nums1[last--] = nums2[ni--];
            }
        }
    }
    /**
     * 方法一 : 合并后排序
     * 直觉
     *
     * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为O((n + m)\log(n + m))O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
     *
     * 实现
     *
     * JavaPython
     *
     * class Solution {
     *   public void merge(int[] nums1, int m, int[] nums2, int n) {
     *     System.arraycopy(nums2, 0, nums1, m, n);
     *     Arrays.sort(nums1);
     *   }
     * }
     * 复杂度分析
     *
     * 时间复杂度 : O((n + m)\log(n + m))O((n+m)log(n+m))。
     * 空间复杂度 : O(1)O(1)。
     *
     *
     *
     * 方法二 : 双指针 / 从前往后
     * 直觉
     *
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)O(n+m)的时间复杂度。
     *
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     *
     * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m)O(m) 的空间复杂度。
     *
     *
     *
     * 实现
     *
     * JavaPython
     *
     * class Solution {
     *   public void merge(int[] nums1, int m, int[] nums2, int n) {
     *     // Make a copy of nums1.
     *     int [] nums1_copy = new int[m];
     *     System.arraycopy(nums1, 0, nums1_copy, 0, m);
     *
     *     // Two get pointers for nums1_copy and nums2.
     *     int p1 = 0;
     *     int p2 = 0;
     *
     *     // Set pointer for nums1
     *     int p = 0;
     *
     *     // Compare elements from nums1_copy and nums2
     *     // and add the smallest one into nums1.
     *     while ((p1 < m) && (p2 < n))
     *       nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
     *
     *     // if there are still elements to add
     *     if (p1 < m)
     *       System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
     *     if (p2 < n)
     *       System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
     *   }
     * }
     * 复杂度分析
     *
     * 时间复杂度 : O(n + m)O(n+m)。
     * 空间复杂度 : O(m)O(m)。
     *
     *
     *
     * 方法三 : 双指针 / 从后往前
     * 直觉
     *
     * 方法二已经取得了最优的时间复杂度O(n + m)O(n+m)，但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。
     *
     * 如果我们从结尾开始改写 nums1 的值又会如何呢？这里没有信息，因此不需要额外空间。
     *
     * 这里的指针 p 用于追踪添加元素的位置。
     *
     *
     *
     *
     * 1 / 6
     *
     * 实现
     *
     * JavaPython
     *
     * class Solution {
     *   public void merge(int[] nums1, int m, int[] nums2, int n) {
     *     // two get pointers for nums1 and nums2
     *     int p1 = m - 1;
     *     int p2 = n - 1;
     *     // set pointer for nums1
     *     int p = m + n - 1;
     *
     *     // while there are still elements to compare
     *     while ((p1 >= 0) && (p2 >= 0))
     *       // compare two elements from nums1 and nums2
     *       // and add the largest one in nums1
     *       nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
     *
     *     // add missing elements from nums2
     *     System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
     *   }
     * }
     * 复杂度分析
     *
     * 时间复杂度 : O(n + m)O(n+m)。
     * 空间复杂度 : O(1)O(1)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}