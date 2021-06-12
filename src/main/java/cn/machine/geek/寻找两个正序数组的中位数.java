package cn.machine.geek;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1, nums2);
        if (result.length == 0) return 0;
        int mid = result.length >> 1;
        if (result.length % 2 == 0) {
            return ((double) (result[mid] + result[mid - 1]) / 2);
        }
        return result[mid];
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] result = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i1 == nums1.length) {
                result[i] = nums2[i2++];
                continue;
            }
            if (i2 == nums2.length) {
                result[i] = nums1[i1++];
                continue;
            }
            if (nums1[i1] > nums2[i2]) {
                result[i] = nums2[i2++];
            } else {
                result[i] = nums1[i1++];
            }
        }
        return result;
    }
    /**
     *
     */
}
