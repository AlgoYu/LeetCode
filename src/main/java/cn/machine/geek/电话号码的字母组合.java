package cn.machine.geek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: MachineGeek
 * @Description:
 * @Email: 794763733@qq.com
 * @Date: 2021/3/5
 */
public class 电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (combination.length() == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        String s = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            combination.append(s.charAt(i));
            backtrack(combinations, phoneMap, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }
    /**
     * 电话号码的字母组合
     * 力扣官方题解
     * 发布于 2020-08-25
     * 74.7k
     * 📺 视频题解
     *
     * 📖 文字题解
     * 方法一：回溯
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
     *
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
     *
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     *
     *
     *
     *
     * class Solution {
     *     public List<String> letterCombinations(String digits) {
     *         List<String> combinations = new ArrayList<String>();
     *         if (digits.length() == 0) {
     *             return combinations;
     *         }
     *         Map<Character, String> phoneMap = new HashMap<Character, String>() {{
     *             put('2', "abc");
     *             put('3', "def");
     *             put('4', "ghi");
     *             put('5', "jkl");
     *             put('6', "mno");
     *             put('7', "pqrs");
     *             put('8', "tuv");
     *             put('9', "wxyz");
     *         }};
     *         backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
     *         return combinations;
     *     }
     *
     *     public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
     *         if (index == digits.length()) {
     *             combinations.add(combination.toString());
     *         } else {
     *             char digit = digits.charAt(index);
     *             String letters = phoneMap.get(digit);
     *             int lettersCount = letters.length();
     *             for (int i = 0; i < lettersCount; i++) {
     *                 combination.append(letters.charAt(i));
     *                 backtrack(combinations, phoneMap, digits, index + 1, combination);
     *                 combination.deleteCharAt(index);
     *             }
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(3^m \times 4^n)O(3
     * m
     *  ×4
     * n
     *  )，其中 mm 是输入中对应 33 个字母的数字个数（包括数字 22、33、44、55、66、88），nn 是输入中对应 44 个字母的数字个数（包括数字 77、99），m+nm+n 是输入数字的总个数。当输入包含 mm 个对应 33 个字母的数字和 nn 个对应 44 个字母的数字时，不同的字母组合一共有 3^m \times 4^n3
     * m
     *  ×4
     * n
     *   种，需要遍历每一种字母组合。
     *
     * 空间复杂度：O(m+n)O(m+n)，其中 mm 是输入中对应 33 个字母的数字个数，nn 是输入中对应 44 个字母的数字个数，m+nm+n 是输入数字的总个数。除了返回值以外，空间复杂度主要取决于哈希表以及回溯过程中的递归调用层数，哈希表的大小与输入无关，可以看成常数，递归调用层数最大为 m+nm+n。
     */
}
