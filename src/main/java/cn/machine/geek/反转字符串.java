package cn.machine.geek;

public class 反转字符串 {
    public void reverseString(char[] s) {
        int left = 0,right = s.length-1;
        while (left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    /**
     * 递归
     * 原地反转字符串是否代表了空间复杂度为常数？
     *
     * 不，原地反转字符串是一种不使用辅助数据结构的算法。
     *
     * 我们使用递归的方法去反转字符串，它是原地反转，但是空间复杂度却不是常数级空间，因为递归过程中使用了堆栈空间。
     *
     * 算法：
     * 我们实现递归函数 helper，它接受两个参数：left 左指针和 right 右指针。
     *
     * 如果 left>=right，不做任何操作。
     * 否则交换 s[left] 和 s[right] 和调用 helper(left + 1, right - 1)。
     * 首次调用函数我们传递首尾指针反转整个字符串 return helper(0, len(s) - 1)。
     * PythonJava
     *
     * class Solution {
     *   public void helper(char[] s, int left, int right) {
     *     if (left >= right) return;
     *     char tmp = s[left];
     *     s[left++] = s[right];
     *     s[right--] = tmp;
     *     helper(s, left, right);
     *   }
     *
     *   public void reverseString(char[] s) {
     *     helper(s, 0, s.length - 1);
     *   }
     * }
     * 复杂度分析
     *
     * 时间复杂度：\mathcal{O}(N)O(N)。执行了 N/2N/2 次的交换。
     * 空间复杂度：\mathcal{O}(N)O(N)，递归过程中使用的堆栈空间。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     */
    public void reverseStringOfficial(char[] s) {
        helper(s, 0, s.length - 1);
    }
    public void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    /**
     * 双指针法
     * 双指针法是使用两个指针，一个左指针 left，右指针 right，开始工作时 left 指向首元素，right 指向尾元素。交换两个指针指向的元素，并向中间移动，直到两个指针相遇。
     *
     * 算法：
     *
     * 将 left 指向首元素，right 指向尾元素。
     * 当 left<right：
     * 交换 s[left] 和 s[right]。
     * left++
     * right++
     *
     * Python
     *
     * class Solution:
     *     def reverseString(self, s):
     *         left, right = 0, len(s) - 1
     *         while left < right:
     *             s[left], s[right] = s[right], s[left]
     *             left, right = left + 1, right - 1
     *
     * class Solution {
     *     public void reverseString(char[] s) {
     *         int left = 0, right = s.length - 1;
     *         while (left < right) {
     *             char tmp = s[left];
     *             s[left++] = s[right];
     *             s[right--] = tmp;
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：\mathcal{O}(N)O(N)。执行了 N/2N/2 次的交换。
     * 空间复杂度：\mathcal{O}(1)O(1)，只使用了常数级空间。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     */
}
