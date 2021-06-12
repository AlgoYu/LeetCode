package cn.machine.geek;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 */
public class 两两交换链表中的节点 {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = new ListNode();
        ListNode result = current;
        current.next = head;
        while (current.next != null && current.next.next != null) {
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;

            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            current = node1;
        }
        return result.next;
    }
    /**
     * 方法一：递归
     * 思路与算法
     *
     * 可以通过递归的方式实现两两交换链表中的节点。
     *
     * 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
     *
     * 如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，原始链表的第二个节点变成新的链表的头节点。链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
     *
     * 用 head 表示原始链表的头节点，新的链表的第二个节点，用 newHead 表示新的链表的头节点，原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next。令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。然后令 newHead.next = head，即完成了所有节点的交换。最后返回新的链表的头节点 newHead。
     *
     * 代码
     *
     * JavaC++JavaScriptPython3GolangC
     *
     * class Solution {
     *     public ListNode swapPairs(ListNode head) {
     *         if (head == null || head.next == null) {
     *             return head;
     *         }
     *         ListNode newHead = head.next;
     *         head.next = swapPairs(newHead.next);
     *         newHead.next = head;
     *         return newHead;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是链表的节点数量。需要对每个节点进行更新指针的操作。
     *
     * 空间复杂度：O(n)O(n)，其中 nn 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。
     *
     * 方法二：迭代
     * 思路与算法
     *
     * 也可以通过迭代的方式实现两两交换链表中的节点。
     *
     * 创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
     *
     * 如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
     *
     * 具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
     *
     *
     * temp.next = node2
     * node1.next = node2.next
     * node2.next = node1
     * 完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
     *
     * 两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可。
     *
     *
     * 1 / 13
     *
     * 代码
     *
     * JavaC++JavaScriptPython3GolangC
     *
     * class Solution {
     *     public ListNode swapPairs(ListNode head) {
     *         ListNode dummyHead = new ListNode(0);
     *         dummyHead.next = head;
     *         ListNode temp = dummyHead;
     *         while (temp.next != null && temp.next.next != null) {
     *             ListNode node1 = temp.next;
     *             ListNode node2 = temp.next.next;
     *             temp.next = node2;
     *             node1.next = node2.next;
     *             node2.next = node1;
     *             temp = node1;
     *         }
     *         return dummyHead.next;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是链表的节点数量。需要对每个节点进行更新指针的操作。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-91/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
