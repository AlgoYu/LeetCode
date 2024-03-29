package xiaoyu.algo.leetcode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class 两数相加 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode linked = new ListNode();
        ListNode head = linked;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int n = 0;
        while (temp1 != null || temp2 != null) {
            int result = n;
            if (temp1 != null) {
                result += temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                result += temp2.val;
                temp2 = temp2.next;
            }
            n = result / 10;
            linked.next = new ListNode(result % 10);
            linked = linked.next;
        }
        if (n > 0) {
            linked.next = new ListNode(n);
        }
        return head.next;
    }
    /**
     * 思路与算法
     *
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     *
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2，进位值为 \textit{carry}carry，则它们的和为 n1+n2+\textit{carry}n1+n2+carry；其中，答案链表处相应位置的数字为 (n1+n2+\textit{carry}) \% 10(n1+n2+carry)%10，而新的进位值为 \lfloor\frac{n1+n2+\textit{carry}}{10}\rfloor⌊
     * 10
     * n1+n2+carry
     * ​
     *  ⌋。
     *
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 00 。
     *
     * 此外，如果链表遍历结束后，有 \textit{carry} > 0carry>0，还需要在答案链表的后面附加一个节点，节点的值为 \textit{carry}carry。
     *
     * 代码
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     *         ListNode head = null, tail = null;
     *         int carry = 0;
     *         while (l1 != null || l2 != null) {
     *             int n1 = l1 != null ? l1.val : 0;
     *             int n2 = l2 != null ? l2.val : 0;
     *             int sum = n1 + n2 + carry;
     *             if (head == null) {
     *                 head = tail = new ListNode(sum % 10);
     *             } else {
     *                 tail.next = new ListNode(sum % 10);
     *                 tail = tail.next;
     *             }
     *             carry = sum / 10;
     *             if (l1 != null) {
     *                 l1 = l1.next;
     *             }
     *             if (l2 != null) {
     *                 l2 = l2.next;
     *             }
     *         }
     *         if (carry > 0) {
     *             tail.next = new ListNode(carry);
     *         }
     *         return head;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\max(m,n))O(max(m,n))，其中 m,nm,n 为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1)O(1) 的时间。
     * 空间复杂度：O(\max(m,n))O(max(m,n))。答案链表的长度最多为较长链表的长度 +1+1。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
