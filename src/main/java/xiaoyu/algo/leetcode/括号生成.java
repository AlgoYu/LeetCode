package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 括号生成
 * 难度
 * 中等
 * <p>
 * 1613
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result, new StringBuilder(), n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder stringBuilder, int n) {
        if (stringBuilder.length() == n * 2 && isValid(stringBuilder)) {
            result.add(stringBuilder.toString());
        }
        if (stringBuilder.length() > n * 2) {
            return;
        }
        stringBuilder.append('(');
        backtrack(result, stringBuilder, n);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append(')');
        backtrack(result, stringBuilder, n);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
    }

    private boolean isValid(StringBuilder s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
    /**
     * 暴力法
     *
     * 思路
     *
     * 我们可以生成所有
     * 2
     * 2
     * n
     * 2
     * 2n
     *   个 '(' 和 ')' 字符构成的序列，然后我们检查每一个是否有效即可。
     *
     * 算法
     *
     * 为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
     *
     * 为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。如果在遍历过程中 balance 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的。
     *
     * JavaPython3C++
     *
     * class Solution {
     *     public List<String> generateParenthesis(int n) {
     *         List<String> combinations = new ArrayList<String>();
     *         generateAll(new char[2 * n], 0, combinations);
     *         return combinations;
     *     }
     *
     *     public void generateAll(char[] current, int pos, List<String> result) {
     *         if (pos == current.length) {
     *             if (valid(current)) {
     *                 result.add(new String(current));
     *             }
     *         } else {
     *             current[pos] = '(';
     *             generateAll(current, pos + 1, result);
     *             current[pos] = ')';
     *             generateAll(current, pos + 1, result);
     *         }
     *     }
     *
     *     public boolean valid(char[] current) {
     *         int balance = 0;
     *         for (char c: current) {
     *             if (c == '(') {
     *                 ++balance;
     *             } else {
     *                 --balance;
     *             }
     *             if (balance < 0) {
     *                 return false;
     *             }
     *         }
     *         return balance == 0;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：
     * O
     * (
     * 2
     * 2
     * n
     * n
     * )
     * O(2
     * 2n
     *  n)，对于
     * 2
     * 2
     * n
     * 2
     * 2n
     *   个序列中的每一个，我们用于建立和验证该序列的复杂度为
     * O
     * (
     * n
     * )
     * O(n)。
     * 空间复杂度：
     * O
     * (
     * n
     * )
     * O(n)，除了答案数组之外，我们所需要的空间取决于递归栈的深度，每一层递归函数需要
     * O
     * (
     * 1
     * )
     * O(1) 的空间，最多递归
     * 2
     * n
     * 2n 层，因此空间复杂度为
     * O
     * (
     * n
     * )
     * O(n)。
     * 方法二：回溯法
     *
     * 思路和算法
     *
     * 方法一还有改进的余地：我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     *
     * 如果左括号数量不大于
     * n
     * n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
     *
     * JavaPython3C++
     *
     * class Solution {
     *     public List<String> generateParenthesis(int n) {
     *         List<String> ans = new ArrayList<String>();
     *         backtrack(ans, new StringBuilder(), 0, 0, n);
     *         return ans;
     *     }
     *
     *     public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
     *         if (cur.length() == max * 2) {
     *             ans.add(cur.toString());
     *             return;
     *         }
     *         if (open < max) {
     *             cur.append('(');
     *             backtrack(ans, cur, open + 1, close, max);
     *             cur.deleteCharAt(cur.length() - 1);
     *         }
     *         if (close < open) {
     *             cur.append(')');
     *             backtrack(ans, cur, open, close + 1, max);
     *             cur.deleteCharAt(cur.length() - 1);
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 我们的复杂度分析依赖于理解 generateParenthesis(n) 中有多少个元素。这个分析超出了本文的范畴，但事实证明这是第
     * n
     * n 个卡特兰数
     * 1
     * n
     * +
     * 1
     * (
     * 2
     * n
     * n
     * )
     * n+1
     * 1
     * ​
     *  (
     * n
     * 2n
     * ​
     *  )，这是由
     * 4
     * n
     * n
     * n
     * n
     * n
     * ​
     *
     * 4
     * n
     *
     * ​
     *   渐近界定的。
     *
     * 时间复杂度：
     * O
     * (
     * 4
     * n
     * n
     * )
     * O(
     * n
     * ​
     *
     * 4
     * n
     *
     * ​
     *  )，在回溯过程中，每个答案需要
     * O
     * (
     * n
     * )
     * O(n) 的时间复制到答案数组中。
     * 空间复杂度：
     * O
     * (
     * n
     * )
     * O(n)，除了答案数组之外，我们所需要的空间取决于递归栈的深度，每一层递归函数需要
     * O
     * (
     * 1
     * )
     * O(1) 的空间，最多递归
     * 2
     * n
     * 2n 层，因此空间复杂度为
     * O
     * (
     * n
     * )
     * O(n)。
     * 方法三：按括号序列的长度递归
     *
     * 思路与算法
     *
     * 任何一个括号序列都一定是由 ( 开头，并且第一个 ( 一定有一个唯一与之对应的 )。这样一来，每一个括号序列可以用 (a)b 来表示，其中 a 与 b 分别是一个合法的括号序列（可以为空）。
     *
     * 那么，要生成所有长度为 2 * n 的括号序列，我们定义一个函数 generate(n) 来返回所有可能的括号序列。那么在函数 generate(n) 的过程中：
     *
     * 我们需要枚举与第一个 ( 对应的 ) 的位置 2 * i + 1；
     * 递归调用 generate(i) 即可计算 a 的所有可能性；
     * 递归调用 generate(n - i - 1) 即可计算 b 的所有可能性；
     * 遍历 a 与 b 的所有可能性并拼接，即可得到所有长度为 2 * n 的括号序列。
     * 为了节省计算时间，我们在每次 generate(i) 函数返回之前，把返回值存储起来，下次再调用 generate(i) 时可以直接返回，不需要再递归计算。
     *
     * JavaPython3C++
     *
     * class Solution {
     *     ArrayList[] cache = new ArrayList[100];
     *
     *     public List<String> generate(int n) {
     *         if (cache[n] != null) {
     *             return cache[n];
     *         }
     *         ArrayList<String> ans = new ArrayList<String>();
     *         if (n == 0) {
     *             ans.add("");
     *         } else {
     *             for (int c = 0; c < n; ++c) {
     *                 for (String left: generate(c)) {
     *                     for (String right: generate(n - 1 - c)) {
     *                         ans.add("(" + left + ")" + right);
     *                     }
     *                 }
     *             }
     *         }
     *         cache[n] = ans;
     *         return ans;
     *     }
     *
     *     public List<String> generateParenthesis(int n) {
     *         return generate(n);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：
     * O
     * (
     * 4
     * n
     * n
     * )
     * O(
     * n
     * ​
     *
     * 4
     * n
     *
     * ​
     *  )，该分析与 方法二 类似。
     * 空间复杂度：
     * O
     * (
     * 4
     * n
     * n
     * )
     * O(
     * n
     * ​
     *
     * 4
     * n
     *
     * ​
     *  )，此方法除答案数组外，中间过程中会存储与答案数组同样数量级的临时数组，是我们所需要的空间复杂度。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
