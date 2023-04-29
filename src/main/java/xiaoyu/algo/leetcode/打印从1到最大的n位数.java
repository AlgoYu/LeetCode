package xiaoyu.algo.leetcode;

/**
 * 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int size = 1;
        for (int i = 0; i < n; i++) {
            size *= 10;
        }
        int[] data = new int[size - 1];
        for (int i = 1; i < size; i++) {
            data[i - 1] = i;
        }
        return data;
    }
    /**
     * 题目要求打印 “从 11 至最大的 nn 位数的列表” ，因此需考虑以下两个问题：
     *
     * 最大的 nn 位数（记为 endend ）和位数 nn 的关系： 例如最大的 11 位数是 99 ，最大的 22 位数是 9999 ，最大的 33 位数是 999999 。则可推出公式：
     * end = 10^n - 1
     * end=10
     * n
     *  −1
     *
     * 大数越界问题： 当 nn 较大时，endend 会超出 int32int32 整型的取值范围，超出取值范围的数字无法正常存储。但由于本题要求返回 int 类型数组，相当于默认所有数字都在 int32 整型取值范围内，因此不考虑大数越界问题。
     * 因此，只需定义区间 [1, 10^n - 1][1,10
     * n
     *  −1] 和步长 11 ，通过 forfor 循环生成结果列表 resres 并返回即可。
     *
     * 复杂度分析：
     * 时间复杂度 O(10^n)O(10
     * n
     *  ) ： 生成长度为 10^n10
     * n
     *   的列表需使用 O(10^n)O(10
     * n
     *  ) 时间。
     * 空间复杂度 O(1)O(1) ： 建立列表需使用 O(1)O(1) 大小的额外空间（ 列表作为返回结果，不计入额外空间 ）。
     * 代码：
     * PythonJava
     *
     * class Solution {
     *     public int[] printNumbers(int n) {
     *         int end = (int)Math.pow(10, n) - 1;
     *         int[] res = new int[end];
     *         for(int i = 0; i < end; i++)
     *             res[i] = i + 1;
     *         return res;
     *     }
     * }
     * 利用 Python 的语言特性，可以简化代码：先使用 range() 方法生成可迭代对象，再使用 list() 方法转化为列表并返回即可。
     *
     *
     * class Solution:
     *     def printNumbers(self, n: int) -> List[int]:
     *         return list(range(1, 10 ** n))
     * 大数打印解法：
     * 实际上，本题的主要考点是大数越界情况下的打印。需要解决以下三个问题：
     *
     * 1. 表示大数的变量类型：
     * 无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型。
     * 2. 生成数字的字符串集：
     * 使用 int 类型时，每轮可通过 +1+1 生成下个数字，而此方法无法应用至 String 类型。并且， String 类型的数字的进位操作效率较低，例如 "9999" 至 "10000" 需要从个位到千位循环判断，进位 4 次。
     *
     * 观察可知，生成的列表实际上是 nn 位 00 - 99 的 全排列 ，因此可避开进位操作，通过递归生成数字的 String 列表。
     *
     * 3. 递归生成全排列：
     * 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。例如当 n = 2n=2 时（数字范围 1 - 991−99 ），固定十位为 00 - 99 ，按顺序依次开启递归，固定个位 00 - 99 ，终止递归并添加数字字符串。
     *
     *
     * 根据以上方法，可初步编写全排列代码：
     *
     * PythonJava
     *
     * class Solution {
     *     StringBuilder res;
     *     int count = 0, n;
     *     char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
     *     public String printNumbers(int n) {
     *         this.n = n;
     *         res = new StringBuilder(); // 数字字符串集
     *         num = new char[n]; // 定义长度为 n 的字符列表
     *         dfs(0); // 开启全排列递归
     *         res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
     *         return res.toString(); // 转化为字符串并返回
     *     }
     *     void dfs(int x) {
     *         if(x == n) { // 终止条件：已固定完所有位
     *             res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
     *             return;
     *         }
     *         for(char i : loop) { // 遍历 ‘0‘ - ’9‘
     *             num[x] = i; // 固定第 x 位为 i
     *             dfs(x + 1); // 开启固定第 x + 1 位
     *         }
     *     }
     * }
     * 在此方法下，各数字字符串被逗号隔开，共同组成长字符串。返回的数字集字符串如下所示：
     *
     *
     * 输入：n = 1
     * 输出："0,1,2,3,4,5,6,7,8,9"
     *
     * 输入：n = 2
     * 输出："00,01,02,...,10,11,12,...,97,98,99"
     *
     * 输入：n = 3
     * 输出："000,001,002,...,100,101,102,...,997,998,999"
     * 观察可知，当前的生成方法仍有以下问题：
     *
     * 诸如 00, 01, 02, \cdots00,01,02,⋯ 应显示为 0, 1, 2, \cdots0,1,2,⋯ ，即应 删除高位多余的 00 ;
     * 此方法从 00 开始生成，而题目要求 列表从 11 开始 ；
     * 以上两个问题的解决方法如下：
     *
     * 1. 删除高位多余的 00 ：
     * 字符串左边界定义： 声明变量 startstart 规定字符串的左边界，以保证添加的数字字符串 num[start:] 中无高位多余的 00 。例如当 n = 2n=2 时， 1 - 91−9 时 start = 1start=1 ， 10 - 9910−99 时 start = 0start=0 。
     *
     * 左边界 startstart 变化规律： 观察可知，当输出数字的所有位都是 99 时，则下个数字需要向更高位进 11 ，此时左边界 startstart 需要减 11 （即高位多余的 00 减少一个）。例如当 n = 3n=3 （数字范围 1 - 9991−999 ）时，左边界 startstart 需要减 11 的情况有： "009" 进位至 "010" ， "099" 进位至 "100" 。设数字各位中 99 的数量为 ninenine ，所有位都为 99 的判断条件可用以下公式表示：
     *
     * n - start = nine
     * n−start=nine
     *
     * 统计 ninenine 的方法： 固定第 xx 位时，当 i = 9i=9 则执行 nine = nine + 1nine=nine+1 ，并在回溯前恢复 nine = nine - 1nine=nine−1 。
     * 2. 列表从 11 开始：
     * 在以上方法的基础上，添加数字字符串前判断其是否为 "0" ，若为 "0" 则直接跳过。
     *
     * 1 / 10
     *
     * 复杂度分析：
     * 时间复杂度 O(10^n)O(10
     * n
     *  ) ： 递归的生成的排列的数量为 10^n10
     * n
     *   。
     * 空间复杂度 O(10^n)O(10
     * n
     *  ) ： 结果列表 resres 的长度为 10^n - 110
     * n
     *  −1 ，各数字字符串的长度区间为 1, 2, ..., n1,2,...,n ，因此占用 O(10^n)O(10
     * n
     *  ) 大小的额外空间。
     * 代码：
     * 为 正确表示大数 ，以下代码的返回值为数字字符串集拼接而成的长字符串。
     *
     * PythonJava
     *
     * class Solution {
     *     StringBuilder res;
     *     int nine = 0, count = 0, start, n;
     *     char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
     *     public String printNumbers(int n) {
     *         this.n = n;
     *         res = new StringBuilder();
     *         num = new char[n];
     *         start = n - 1;
     *         dfs(0);
     *         res.deleteCharAt(res.length() - 1);
     *         return res.toString();
     *     }
     *     void dfs(int x) {
     *         if(x == n) {
     *             String s = String.valueOf(num).substring(start);
     *             if(!s.equals("0")) res.append(s + ",");
     *             if(n - start == nine) start--;
     *             return;
     *         }
     *         for(char i : loop) {
     *             if(i == '9') nine++;
     *             num[x] = i;
     *             dfs(x + 1);
     *         }
     *         nine--;
     *     }
     * }
     * 本题要求输出 int 类型数组。为 运行通过 ，可在添加数字字符串 ss 前，将其转化为 int 类型。代码如下所示：
     *
     * PythonJava
     *
     * class Solution {
     *     int[] res;
     *     int nine = 0, count = 0, start, n;
     *     char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
     *     public int[] printNumbers(int n) {
     *         this.n = n;
     *         res = new int[(int)Math.pow(10, n) - 1];
     *         num = new char[n];
     *         start = n - 1;
     *         dfs(0);
     *         return res;
     *     }
     *     void dfs(int x) {
     *         if(x == n) {
     *             String s = String.valueOf(num).substring(start);
     *             if(!s.equals("0")) res[count++] = Integer.parseInt(s);
     *             if(n - start == nine) start--;
     *             return;
     *         }
     *         for(char i : loop) {
     *             if(i == '9') nine++;
     *             num[x] = i;
     *             dfs(x + 1);
     *         }
     *         nine--;
     *     }
     * }
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
