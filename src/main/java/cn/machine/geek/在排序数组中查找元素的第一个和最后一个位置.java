package cn.machine.geek;

/**
 * @Author: MachineGeek
 * @Description:
 * @Email: 794763733@qq.com
 * @Date: 2021/3/12
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums.length == 0) return result;
        int index = binarySearch(nums, target);
        if(index == -1) return result;
        int left = index - 1,right = index + 1;
        while(left >= 0 && nums[left] == target) left--;
        while (right < nums.length && nums[right] == target) right++;
        result[0] = left + 1;
        result[1] = right - 1;
        return result;
    }
    private int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 方法一：二分查找
     * 直观的思路肯定是从前往后遍历一遍。用两个变量记录第一次和最后一次遇见 \textit{target}target 的下标，但这个方法的时间复杂度为 O(n)O(n)，没有利用到数组升序排列的条件。
     *
     * 由于数组已经排序，因此整个数组是单调递增的，我们可以利用二分法来加速查找的过程。
     *
     * 考虑 \textit{target}target 开始和结束位置，其实我们要找的就是数组中「第一个等于 \textit{target}target 的位置」（记为 \textit{leftIdx}leftIdx）和「第一个大于 \textit{target}target 的位置减一」（记为 \textit{rightIdx}rightIdx）。
     *
     * 二分查找中，寻找 \textit{leftIdx}leftIdx 即为在数组中寻找第一个大于等于 \textit{target}target 的下标，寻找 \textit{rightIdx}rightIdx 即为在数组中寻找第一个大于 \textit{target}target 的下标，然后将下标减一。两者的判断条件不同，为了代码的复用，我们定义 binarySearch(nums, target, lower) 表示在 \textit{nums}nums 数组中二分查找 \textit{target}target 的位置，如果 \textit{lower}lower 为 \rm truetrue，则查找第一个大于等于 \textit{target}target 的下标，否则查找第一个大于 \textit{target}target 的下标。
     *
     * 最后，因为 \textit{target}target 可能不存在数组中，因此我们需要重新校验我们得到的两个下标 \textit{leftIdx}leftIdx 和 \textit{rightIdx}rightIdx，看是否符合条件，如果符合条件就返回 [\textit{leftIdx},\textit{rightIdx}][leftIdx,rightIdx]，不符合就返回 [-1,-1][−1,−1]。
     *
     *
     * 1 / 14
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     public int[] searchRange(int[] nums, int target) {
     *         int leftIdx = binarySearch(nums, target, true);
     *         int rightIdx = binarySearch(nums, target, false) - 1;
     *         if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
     *             return new int[]{leftIdx, rightIdx};
     *         }
     *         return new int[]{-1, -1};
     *     }
     *
     *     public int binarySearch(int[] nums, int target, boolean lower) {
     *         int left = 0, right = nums.length - 1, ans = nums.length;
     *         while (left <= right) {
     *             int mid = (left + right) / 2;
     *             if (nums[mid] > target || (lower && nums[mid] >= target)) {
     *                 right = mid - 1;
     *                 ans = mid;
     *             } else {
     *                 left = mid + 1;
     *             }
     *         }
     *         return ans;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度： O(\log n)O(logn) ，其中 nn 为数组的长度。二分查找的时间复杂度为 O(\log n)O(logn)，一共会执行两次，因此总时间复杂度为 O(\log n)O(logn)。
     *
     * 空间复杂度：O(1)O(1) 。只需要常数空间存放若干变量。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
