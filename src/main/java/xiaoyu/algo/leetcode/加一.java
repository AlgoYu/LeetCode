package xiaoyu.algo.leetcode;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int pre = 1;
        while (index >= 0) {
            int n = digits[index] + pre;
            digits[index] = n % 10;
            pre = n / 10;
            index--;
        }
        if (pre > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = pre;
            for (int i = 1; i < digits.length; i++) {
                digits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }
}
