package xiaoyu.algo.leetcode;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */
public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int flower = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1 >= 0 ? i - 1 : i] == 0 && flowerbed[i + 1 < flowerbed.length ? i + 1 : i] == 0) {
                flowerbed[i] = 1;
                flower++;
                if (flower >= n) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 方法一：贪心
     * 我们从左到右扫描数组 flowerbed，如果数组中有一个 0，并且这个 0 的左右两侧都是 0，那么我们就可以在这个位置种花，即将这个位置的 0 修改成 1，并将计数器 count 增加 1。对于数组的第一个和最后一个位置，我们只需要考虑一侧是否为 0。
     *
     * 在扫描结束之后，我们将 count 与 n 进行比较。如果 count >= n，那么返回 True，否则返回 False。
     *
     * Java
     *
     * public class Solution {
     *     public boolean canPlaceFlowers(int[] flowerbed, int n) {
     *         int i = 0, count = 0;
     *         while (i < flowerbed.length) {
     *             if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
     *                 flowerbed[i] = 1;
     *                 count++;
     *             }
     *             i++;
     *         }
     *         return count >= n;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是数组 flowerbed 的长度。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 方法二：贪心 + 常数优化
     * 我们可以优化方法一中的常数。在扫描数组 flowerbed 时，如果 count 的值已经达到 n，那么我们可以直接跳出循环并返回 True。
     *
     * Java
     *
     * public class Solution {
     *     public boolean canPlaceFlowers(int[] flowerbed, int n) {
     *         int i = 0, count = 0;
     *         while (i < flowerbed.length) {
     *             if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
     *                 flowerbed[i++] = 1;
     *                 count++;
     *             }
     *              if(count>=n)
     *                 return true;
     *             i++;
     *         }
     *         return false;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是数组 flowerbed 的长度。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
