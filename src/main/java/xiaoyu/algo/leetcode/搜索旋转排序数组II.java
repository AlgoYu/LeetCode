package xiaoyu.algo.leetcode;

/**
 * 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class 搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == target || nums[i] == target) {
                return true;
            }
            if (nums[i] < nums[i - 1]) {
                return binarySearch(nums, i, nums.length, target) != -1;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 本题是需要使用二分查找，怎么分是关键，举个例子：
     *
     * 第一类
     * 1011110111 和 1110111101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
     * 第二类
     * 22 33 44 55 66 77 11 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
     * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
     * 第三类
     * 66 77 11 22 33 44 55 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
     * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
     * 代码:
     * Java
     *
     * public boolean search(int[] nums, int target) {
     *         if (nums == null || nums.length == 0) {
     *             return false;
     *         }
     *         int start = 0;
     *         int end = nums.length - 1;
     *         int mid;
     *         while (start <= end) {
     *             mid = start + (end - start) / 2;
     *             if (nums[mid] == target) {
     *                 return true;
     *             }
     *             if (nums[start] == nums[mid]) {
     *                 start++;
     *                 continue;
     *             }
     *             //前半部分有序
     *             if (nums[start] < nums[mid]) {
     *                 //target在前半部分
     *                 if (nums[mid] > target && nums[start] <= target) {
     *                     end = mid - 1;
     *                 } else {  //否则，去后半部分找
     *                     start = mid + 1;
     *                 }
     *             } else {
     *                 //后半部分有序
     *                 //target在后半部分
     *                 if (nums[mid] < target && nums[end] >= target) {
     *                     start = mid + 1;
     *                 } else {  //否则，去后半部分找
     *                     end = mid - 1;
     *
     *                 }
     *             }
     *         }
     *         //一直没找到，返回false
     *         return false;
     *
     *     }
     *
     * 作者：reedfan
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}