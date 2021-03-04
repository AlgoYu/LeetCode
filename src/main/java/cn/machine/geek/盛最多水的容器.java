package cn.machine.geek;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        if(height == null || height.length < 1){
            return 0;
        }
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r){
            max = Math.max(Math.min(height[l],height[r]) * (r - l),max);
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
    /**
     *
     \min(x, y_t) * t_1 < \min(x, y) * t
     min(x,y
     t
     ​
     )∗t
     1
     ​
     <min(x,y)∗t

     即无论我们怎么移动右指针，得到的容器的容量都小于移动前容器的容量。也就是说，这个左指针对应的数不会作为容器的边界了，那么我们就可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针于原先的右指针之间的左右位置，才可能会作为容器的边界。

     这样以来，我们将问题的规模减小了 11，被我们丢弃的那个位置就相当于消失了。此时的左右指针，就指向了一个新的、规模减少了的问题的数组的左右边界，因此，我们可以继续像之前 考虑第一步 那样考虑这个问题：

     求出当前双指针对应的容器的容量；

     对应数字较小的那个指针以后不可能作为容器的边界了，将其丢弃，并移动对应的指针。

     最后的答案是什么？

     答案就是我们每次以双指针为左右边界（也就是「数组」的左右边界）计算出的容量中的最大值。

     C++JavaPython3

     public class Solution {
     public int maxArea(int[] height) {
     int l = 0, r = height.length - 1;
     int ans = 0;
     while (l < r) {
     int area = Math.min(height[l], height[r]) * (r - l);
     ans = Math.max(ans, area);
     if (height[l] <= height[r]) {
     ++l;
     }
     else {
     --r;
     }
     }
     return ans;
     }
     }
     复杂度分析

     时间复杂度：O(N)O(N)，双指针总计最多遍历整个数组一次。

     空间复杂度：O(1)O(1)，只需要额外的常数级别的空间。

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
