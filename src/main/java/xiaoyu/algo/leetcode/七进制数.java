package xiaoyu.algo.leetcode;

/**
 * 504. 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 */
public class 七进制数 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int n = Math.abs(num);
        StringBuilder stringBuilder = new StringBuilder();
        while (n >= 7) {
            stringBuilder.append(n % 7);
            n = n / 7;
        }
        stringBuilder.append(n);
        stringBuilder.reverse();
        if (num < 0) {
            stringBuilder.insert(0, '-');
        }
        return stringBuilder.toString();
    }
}
