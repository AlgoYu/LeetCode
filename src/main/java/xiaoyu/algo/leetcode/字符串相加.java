package xiaoyu.algo.leetcode;

/**
 * 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int max = Math.max(num1.length(), num2.length());
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        while (max > 0) {
            int v1 = i1 >= 0 ? num1.charAt(i1--) - '0' : 0;
            int v2 = i2 >= 0 ? num2.charAt(i2--) - '0' : 0;
            int sum = v1 + v2 + pre;
            sb.append(sum % 10);
            pre = sum / 10;
            max--;
        }
        if (pre > 0) {
            sb.append(pre);
        }
        return sb.reverse().toString();
    }
}
