package cn.machine.geek;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class 反转链表II {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        ListNode virtual = new ListNode(-1);
        virtual.next = head;

        ListNode front = virtual;
        for (int i = 0; i < left - 1; i++){
            front = front.next;
        }

        ListNode back = front;
        for (int i = 0; i <= right - left; i++){
            back = back.next;
        }

        ListNode leftNode = front.next;
        front.next = null;

        ListNode rightNode = back;
        back = rightNode.next;
        rightNode.next = null;

        ListNode tmp = null;
        ListNode backUp = leftNode;
        while (leftNode.next != null){
            ListNode nextNode = leftNode.next;
            leftNode.next = tmp;
            tmp = leftNode;
            leftNode = nextNode;
        }
        leftNode.next = tmp;

        front.next = leftNode;
        backUp.next = back;
        return virtual.next;
    }
    /**
     * 前言
     * 链表的操作问题，一般而言面试（机试）的时候不允许我们修改节点的值，而只能修改节点的指向操作。
     *
     * 思路通常都不难，技巧就是一定要先想清楚思路，并且在草稿纸上画图，然后编码。
     *
     * 方法一：穿针引线
     * 我们以下图中黄色区域的链表反转为例。
     *
     *
     *
     * 使用「206. 反转链表」的解法，反转 left 到 right 部分以后，再拼接起来。我们还需要记录 left 的前一个节点，和 right 的后一个节点。如图所示：
     *
     *
     *
     * 算法步骤：
     *
     * 第 1 步：先将待反转的区域反转；
     * 第 2 步：把 pre 的 next 指针指向反转以后的链表头节点，把反转以后的链表的尾节点的 next 指针指向 succ。
     *
     *
     * 说明：编码细节我们不在题解中介绍了，请见下方代码。思路想明白以后，编码不是一件很难的事情。这里要提醒大家的是，链接什么时候切断，什么时候补上去，先后顺序一定要想清楚，如果想不清楚，可以在纸上模拟，让思路清晰。
     *
     * 代码
     *
     * C++JavaPython3GolangCJavaScript
     *
     * class Solution {
     *     public ListNode reverseBetween(ListNode head, int left, int right) {
     *         // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
     *         ListNode dummyNode = new ListNode(-1);
     *         dummyNode.next = head;
     *
     *         ListNode pre = dummyNode;
     *         // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
     *         // 建议写在 for 循环里，语义清晰
     *         for (int i = 0; i < left - 1; i++) {
     *             pre = pre.next;
     *         }
     *
     *         // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
     *         ListNode rightNode = pre;
     *         for (int i = 0; i < right - left + 1; i++) {
     *             rightNode = rightNode.next;
     *         }
     *
     *         // 第 3 步：切断出一个子链表（截取链表）
     *         ListNode leftNode = pre.next;
     *         ListNode curr = rightNode.next;
     *
     *         // 注意：切断链接
     *         pre.next = null;
     *         rightNode.next = null;
     *
     *         // 第 4 步：同第 206 题，反转链表的子区间
     *         reverseLinkedList(leftNode);
     *
     *         // 第 5 步：接回到原来的链表中
     *         pre.next = rightNode;
     *         leftNode.next = curr;
     *         return dummyNode.next;
     *     }
     *
     *     private void reverseLinkedList(ListNode head) {
     *         // 也可以使用递归反转一个链表
     *         ListNode pre = null;
     *         ListNode cur = head;
     *
     *         while (cur != null) {
     *             ListNode next = cur.next;
     *             cur.next = pre;
     *             pre = cur;
     *             cur = next;
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是链表总节点数。最坏情况下，需要遍历整个链表。
     *
     * 空间复杂度：O(1)O(1)。只使用到常数个变量。
     *
     * 方法二：一次遍历「穿针引线」反转链表
     * 方法一的缺点是：如果 left 和 right 的区域很大，恰好是链表的头节点和尾节点时，找到 left 和 right 需要遍历一次，反转它们之间的链表还需要遍历一次，虽然总的时间复杂度为 O(N)O(N)，但遍历了链表 22 次，可不可以只遍历一次呢？答案是可以的。我们依然画图进行说明。
     *
     * 我们依然以方法一的示例为例进行说明。
     *
     *
     *
     * 整理思想是：在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置。下面的图展示了整个流程。
     *
     *
     *
     * 下面我们具体解释如何实现。使用三个指针变量 pre、curr、next 来记录反转的过程中需要的变量，它们的意义如下：
     *
     * curr：指向待反转区域的第一个节点 left；
     * next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 next 会变化；
     * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
     * 第 1 步，我们使用 ①、②、③ 标注「穿针引线」的步骤。
     *
     *
     *
     * 操作步骤：
     *
     * 先将 curr 的下一个节点记录为 next；
     * 执行操作 ①：把 curr 的下一个节点指向 next 的下一个节点；
     * 执行操作 ②：把 next 的下一个节点指向 curr；
     * 执行操作 ③：把 pre 的下一个节点指向 next。
     * 第 1 步完成以后「拉直」的效果如下：
     *
     *
     *
     * 第 2 步，同理。同样需要注意 「穿针引线」操作的先后顺序。
     *
     *
     *
     * 第 2 步完成以后「拉直」的效果如下：
     *
     *
     *
     * 第 3 步，同理。
     *
     *
     *
     * 第 3 步完成以后「拉直」的效果如下：
     *
     *
     *
     * 代码
     *
     * C++JavaPython3GolangCJavaScript
     *
     * class Solution {
     *     public ListNode reverseBetween(ListNode head, int left, int right) {
     *         // 设置 dummyNode 是这一类问题的一般做法
     *         ListNode dummyNode = new ListNode(-1);
     *         dummyNode.next = head;
     *         ListNode pre = dummyNode;
     *         for (int i = 0; i < left - 1; i++) {
     *             pre = pre.next;
     *         }
     *         ListNode cur = pre.next;
     *         ListNode next;
     *         for (int i = 0; i < right - left; i++) {
     *             next = cur.next;
     *             cur.next = next.next;
     *             next.next = pre.next;
     *             pre.next = next;
     *         }
     *         return dummyNode.next;
     *     }
     * }
     * 复杂度分析：
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是链表总节点数。最多只遍历了链表一次，就完成了反转。
     *
     * 空间复杂度：O(1)O(1)。只使用到常数个变量。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
