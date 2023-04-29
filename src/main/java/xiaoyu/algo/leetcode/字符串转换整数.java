package xiaoyu.algo.leetcode;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 字符串转换整数 {
    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        boolean flag = true;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (s.charAt(i) == '-' || s.charAt(i) == '+' && i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                stringBuilder.append(s.charAt(i));
                i++;
            }
            while (i < s.length() && (Character.isDigit(s.charAt(i)))) {
                flag = false;
                stringBuilder.append(s.charAt(i));
                i++;
            }
            if (flag) {
                return 0;
            } else {
                break;
            }
        }
        int value = 0;
        try {
            if (stringBuilder.length() > 0) {
                value = Integer.parseInt(stringBuilder.toString());
            }
        } catch (RuntimeException e) {
            if (stringBuilder.charAt(0) == '-' && stringBuilder.length() >= 2) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return value;
    }

    /**
     * 视频题解
     * 简述
     * 根据问题的描述我们来判断并且描述对应的解题方法。对于这道题目，很明显是字符串的转化问题。需要明确转化规则，尽量根据转化规则编写对应的子函数。
     *
     * 这里我们要进行模式识别，一旦涉及整数的运算，我们需要注意溢出。本题可能产生溢出的步骤在于推入，乘 10 操作和累加操作都可能造成溢出。对于溢出的处理方式通常可以转换为 INT_MAX 的逆操作。比如判断某数乘 10 是否会溢出，那么就把该数和 INT_MAX 除 10 进行比较。
     *
     *
     * 文字题解
     * 方法一：自动机
     * 思路
     *
     * 字符串处理的题目往往涉及复杂的流程以及条件情况，如果直接上手写程序，一不小心就会写出极其臃肿的代码。
     *
     * 因此，为了有条理地分析每个输入字符的处理方法，我们可以使用自动机这个概念：
     *
     * 我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题。
     *
     * 算法
     *
     * 本题可以建立如下图所示的自动机：
     *
     *
     *
     * 我们也可以用下面的表格来表示这个自动机：
     *
     * ' '	+/-	number	other
     * start	start	signed	in_number	end
     * signed	end	end	in_number	end
     * in_number	end	end	in_number	end
     * end	end	end	end	end
     * 接下来编程部分就非常简单了：我们只需要把上面这个状态转换表抄进代码即可。
     *
     * 另外自动机也需要记录当前已经输入的数字，只要在 s' 为 in_number 时，更新我们输入的数字，即可最终得到输入的数字。
     *
     * Python3C++Java
     *
     * class Solution {
     *     public int myAtoi(String str) {
     *         Automaton automaton = new Automaton();
     *         int length = str.length();
     *         for (int i = 0; i < length; ++i) {
     *             automaton.get(str.charAt(i));
     *         }
     *         return (int) (automaton.sign * automaton.ans);
     *     }
     * }
     *
     * class Automaton {
     *     public int sign = 1;
     *     public long ans = 0;
     *     private String state = "start";
     *     private Map<String, String[]> table = new HashMap<String, String[]>() {{
     *         put("start", new String[]{"start", "signed", "in_number", "end"});
     *         put("signed", new String[]{"end", "end", "in_number", "end"});
     *         put("in_number", new String[]{"end", "end", "in_number", "end"});
     *         put("end", new String[]{"end", "end", "end", "end"});
     *     }};
     *
     *     public void get(char c) {
     *         state = table.get(state)[get_col(c)];
     *         if ("in_number".equals(state)) {
     *             ans = ans * 10 + c - '0';
     *             ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
     *         } else if ("signed".equals(state)) {
     *             sign = c == '+' ? 1 : -1;
     *         }
     *     }
     *
     *     private int get_col(char c) {
     *         if (c == ' ') {
     *             return 0;
     *         }
     *         if (c == '+' || c == '-') {
     *             return 1;
     *         }
     *         if (Character.isDigit(c)) {
     *             return 2;
     *         }
     *         return 3;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为字符串的长度。我们只需要依次处理所有的字符，处理每个字符需要的时间为 O(1)O(1)。
     *
     * 空间复杂度：O(1)O(1)，自动机的状态只需要常数空间存储。
     *
     * 下一篇：Python 1 行 为什么可以用正则表达式？
     * © 著作权归作者所有
     * 161
     * 条评论
     *
     * 最热
     *
     * 编辑
     * 预览
     *
     *
     *
     *
     *
     *
     *
     * 评论
     * 精选评论(5)
     *
     * Edward Elric
     * （编辑过）2020-04-03
     * 准确地说，这是确定有限状态机（deterministic finite automaton, DFA）。其实这题已经不算是容易写“出臃肿代码”的了。考虑清楚边界（主要是溢出处理）和输入种类（+, -, 0-9以及其他），大概在20行内完成代码不难。说实话LC官方题解里很少见给出标准DFA解法的，点个赞。另外看到评论区乌烟瘴气的，真让人唏嘘（没有一点基本的敬畏心、浮躁功利、认为题目边界太复杂导致自己不能AC，那是何其自负）。给两个更加需要DFA的题目吧：utf-8-validation ( 附dfa解法 ) 以及 valid-number。 顺便贴一下普通解法（那种臃肿的、易错的、可能会被test cases虐到骂娘的；但如果骂娘了，本质还是基本功不扎实）。
     *
     * class Solution {
     *     public int myAtoi(String str) {
     *         str = str.trim();
     *         if (str.length() == 0) return 0;
     *         if (!Character.isDigit(str.charAt(0))
     *             && str.charAt(0) != '-' && str.charAt(0) != '+')
     *             return 0;
     *         long ans = 0L;
     *         boolean neg = str.charAt(0) == '-';
     *         int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
     *         while (i < str.length() && Character.isDigit(str.charAt(i))) {
     *             ans = ans * 10 + (str.charAt(i++) - '0');
     *             if (!neg && ans > Integer.MAX_VALUE) {
     *                 ans = Integer.MAX_VALUE;
     *                 break;
     *             }
     *             if (neg && ans > 1L + Integer.MAX_VALUE) {
     *                 ans = 1L + Integer.MAX_VALUE;
     *                 break;
     *             }
     *         }
     *         return neg ? (int) -ans : (int) ans;
     *     }
     * }
     * ----2020.6.9 update------
     *
     * 评论区有一点很有趣，大家对于能不能使用long颇有争议。很多时候大家对于“脑筋急转弯式”的题目是有天然抵抗的，因为背离了算法的核心：比如，不允许使用“if-else”，“for循环”去实现某个题目，面试题64. 求1+2+…+n。这其实可以理解，作为闲时趣味可以，但作为专业问题，“脑筋急转弯”总让人觉得脱离实际。
     *
     * 但是具体到这题上，有很多人又陷入了“脑筋急转弯”式的问题解读思维上。且不说世界上根本就不存在只能存int不能存long的硬件平台（当然，硬件指令和存取速度可能会随总线宽度而变），这题真的是想在考察边界处理下，再给你加一道“脑筋急转弯”式的声明吗去禁用long吗？所以我个人倾向于，题目只是在给我们要实现的atoi确立一个合理的取值范围罢了。当然，每个人可以由不同的解读，不想用long就多一些溢出判断就可以了（当然，实际写的时候，溢出问题一般需要“反向思考”，还需仔细）。但，这真的是本题的核心吗？
     *
     * class Solution {
     *     public int myAtoi(String str) {
     *         str = str.trim();
     *         if (str.length() == 0) return 0;
     *         if (!Character.isDigit(str.charAt(0))
     *             && str.charAt(0) != '-' && str.charAt(0) != '+')
     *             return 0;
     *         int ans = 0;
     *         boolean neg = str.charAt(0) == '-';
     *         int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
     *         while (i < str.length() && Character.isDigit(str.charAt(i))) {
     *             int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(i) - '0')) / 10;
     *             if (tmp > ans) {
     *                 return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
     *             }
     *             ans = ans * 10 - (str.charAt(i++) - '0');
     *         }
     *         return neg ? ans : -ans;
     *     }
     * }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
