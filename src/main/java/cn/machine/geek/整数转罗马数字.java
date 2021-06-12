package cn.machine.geek;

/**
 * 概述
 * 在许多国家，罗马数字在小学就就有教学。这对于它们来说是一个轻松的面试问题。然而并不是每个人都在学校里面学过，因此学过的人就获得了很大的优势。这是不公平也令人沮丧的，但是你要记住你能够做的就是把这个问题和相关的问题从头到尾解决，这样你就不会在面试中遇到麻烦。
 * <p>
 * 先从罗马数到整数开始
 * <p>
 * 把罗马数字转换成整数的问题比较简单。因此，如果你觉得这个问题很难，我们建议你先解决这个问题。这将使您能够更加熟悉罗马数字的概念，而不会出现将整数转换为罗马数字时出现的“歧义”问题。当将罗马数字转换为整数时，只有一个合理的转换。
 * <p>
 * 罗马数字符号
 * <p>
 * 罗马数字由 7 个单字母符号组成，每个符号都有自己的价值。此外，减法规则（如问题描述中所述）给出了额外的 6 个符号。这给了我们总共 13 个独特的符号（每个符号由 1 个字母或 2 个字母组成）。
 * <p>
 * <p>
 * 一个整数被表示为一个罗马数字，通过查找符号来增加它的值。
 * <p>
 * 歧义处理
 * <p>
 * 如果你不熟悉罗马数字，有一件事会让你有点困惑，那就是知道哪种表示法是一个特定整数的“正确”表示法。例如，考虑 140 表示的可能方法。哪一个是正确的？
 * <p>
 * <p>
 * <p>
 * 我们用来决定的规则是从左到右选择尽可能大的符号表示。例如，上面以最大符号开头的表示法是以 C 开头的表示法。
 * <p>
 * <p>
 * <p>
 * 为了决定使用哪一个表示法，我们看下一个符号。其中两个为 X 值 10，一个 XL 值 40。因为 XL 更大，所以我们采用这种表示法。因此，140 的表示是 CXL。
 * <p>
 * 现在，罗马数字的这个定义是 “最被接受的”。有趣的是，它仍然不是一个绝对的标准，纵观历史，已经有很多变种。如果你对数学和历史感兴趣，我们建议你自己去看看维基百科的文章。
 * <p>
 * 方法一：贪心
 * 将给定的整数转换为罗马数字需要找到上述 13 个符号的序列，这些符号的对应值加起来就是整数。根据符号值，此序列必须按从大到小的顺序排列。符号值如下。
 * <p>
 * <p>
 * <p>
 * 如概述中所述，表示应该使用尽可能大的符号，从左侧开始工作。因此，使用贪心算法是有意义的。贪心算法是一种在当前时间做出最佳可能决策的算法；在这种情况下，它会取出最大可能的符号。
 * <p>
 * 为了表示一个给定的整数，我们寻找适合它的最大符号。我们减去它，然后寻找适合余数的最大符号，依此类推，直到余数为0。我们取出的每个符号都附加到输出的罗马数字字符串上。
 * <p>
 * 例如，假设我们需要将数字设为 671。
 * <p>
 * 671 中最大的符号是 D（值 500）。
 * <p>
 * <p>
 * Roman Numeral so far: D
 * Integer remainder: 671 - 500 = 171
 * 我们在 171 的基础重复以上步骤，最大的符号是 C（值 100）。
 * <p>
 * <p>
 * Roman Numeral so far: DC
 * Integer remainder: 171 - 100 = 71
 * 在 71 的基础重复以上步骤，最大的符号是 L （值 50）。
 * <p>
 * <p>
 * Roman Numeral so far: DCL
 * Integer remainder: 71 - 50 = 21
 * 在 21 的基础重复以上步骤，最大的符号是 X （值 10）。
 * <p>
 * <p>
 * Roman Numeral so far: DCLX
 * Integer remainder: 21 - 10 = 11
 * 在 11 的基础重复以上步骤，最大的符号是 X （值 10）。
 * <p>
 * <p>
 * Roman Numeral so far: DCLXX
 * Integer remainder: 11 - 10 = 1
 * 最后，用 I 表示 1，完成转换。
 * <p>
 * <p>
 * Roman Numeral so far: DCLXXI
 * Integer remainder: 1 - 1 = 0
 * 在伪代码中，该算法如下：
 * <p>
 * <p>
 * define function to_roman(integer):
 * roman_numeral = ""
 * while integer is non-zero:
 * symbol = biggest valued symbol that fits into integer
 * roman_numeral = concat roman_numeral and symbol
 * integer = integer - value of symbol
 * return roman_numeral
 * 在代码中实现这一点的最简单的方法是从最大到最小循环遍历每个符号，检查当前符号的有多少个副本适合剩余的整数。
 * <p>
 * <p>
 * define function to_roman(integer):
 * roman_numeral = ""
 * for each symbol from largest to smallest:
 * if value of symbol is greater than integer:
 * continue
 * symbol_count = number of times symbol value fits into integer
 * repeat symbol_count times:
 * roman_numeral = concat roman_numeral and symbol
 * integer = integer - (value of symbol * symbol_count)
 * <p>
 * return roman_numeral
 * 以下动画显示了算法在 478 上运行的情况：
 * <p>
 * <p>
 * 1 / 19
 * <p>
 * 算法：
 * <p>
 * PythonJava
 * <p>
 * int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
 * String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
 * <p>
 * public String intToRoman(int num) {
 * StringBuilder sb = new StringBuilder();
 * // Loop through each symbol, stopping if num becomes 0.
 * for (int i = 0; i < values.length && num >= 0; i++) {
 * // Repeat while the current symbol still fits into num.
 * while (values[i] <= num) {
 * num -= values[i];
 * sb.append(symbols[i]);
 * }
 * }
 * return sb.toString();
 * }
 * 复杂度分析
 * <p>
 * 时间复杂度：O(1)O(1)。由于有一组有限的罗马数字，循环可以迭代多少次有一个硬上限。因此，我们说时间复杂度是常数的，即 O(1)O(1)。
 * 空间复杂度：O(1)O(1)，使用的内存量不会随输入整数的大小而改变，因此是常数的。
 * 方法二：硬编码数字
 * 你会发现，当把整数转换成罗马数字时，整数的十进制表示中的每一个数字都可以单独处理。所有的符号可以根据在 1000，100，10 和 1 的最大因子分成多个组。
 * <p>
 * <p>
 * 当数字至少为 1000 时，将向输出追加 M(1000），并从整数中减去 1000。其他符号在数字低于 1000 之前都不会被考虑。此外，M(1000) 不能表示数字的任何较低的部分。因此，我们可以用 M(1000) 来表示整数的千位。
 * <p>
 * 现在，假设我们有 100 到 999 之间的余数。接下来考虑在此范围的符号。最高的符号是 CM(900)，最低的是 C(100)。此范围内的任何符号都不可能修改成十或一。只要余数仍在100以上，我们就至少可以取 C(100)。这意味着只要数字至少是 100，我们就只能从余数中减去符号。
 * <p>
 * 同样的方法也适用于十，然后是一。
 * <p>
 * 因此，我们可以计算出每个数字在每个地方的表示形式。总共有 34 个，千列是 0、1、2、3、4，百、十、一列是 0、1、2、3、4、5、6、7、8、9。因此，计算出它们的表示情况，并对它们进行硬编码。然后，将整数转换为罗马数字将需要将整数分解为并将每个数字的表示追加到结果。
 * <p>
 * <p>
 * 使用模运算和除法运算，可以得到我们数字中每个位上的数字。
 * <p>
 * <p>
 * thousands_digit = integer / 1000
 * hundreds_digit = (integer % 1000) / 100
 * tens_digit = (integer % 100) / 10
 * ones_digit = integer % 10
 * 然后，我们可以简单地在硬编码表中查找这些结果，并将结果附加在一起！
 * <p>
 * 算法：
 * <p>
 * 在代码中实现它最简单的方法是使用 4 个独立的数组；每个位置值对应一个数组。然后，在输入数字中提取每个位置的数字，在相关数组中查找它们的符号，并将它们全部附加在一起。
 * <p>
 * PythonJava
 * <p>
 * public String intToRoman(int num) {
 * <p>
 * String[] thousands = {"", "M", "MM", "MMM"};
 * String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 * String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 * String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 * <p>
 * return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
 * }
 * 复杂度分析
 * <p>
 * 时间复杂度：O(1)O(1)。无论输入的大小，都会执行相同数量的操作。因此，时间复杂度是常数的。
 * 空间复杂度：O(1)O(1)，虽然我们使用数组，但不管输入的大小，它们都是相同的大小。因此，它们是常数级空间。
 * 这种方法的缺点是，如果要扩展罗马数字，它是不灵活的（这是一个有趣的后续问题）。例如，如果我们说符号 H 现在表示 5000，而 P 现在表示 10000，允许我们表示多达 39999 的数字，会怎么样？方法 1 修改起来要快得多，因为您只需要将这两个值添加到代码中，而不需要进行任何计算。但是对于方法 2，您需要计算并硬编码 10 个新的表示。如果我们再加上一些符号就能达到 39999999 呢？方法2变得越来越难管理，我们添加的符号越多。
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 整数转罗马数字 {
    private int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] chars = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                stringBuilder.append(chars[i]);
                num -= values[i];
            }
        }
        return stringBuilder.toString();
    }
}
