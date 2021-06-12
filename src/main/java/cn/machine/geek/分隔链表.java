package cn.machine.geek;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class 分隔链表 {
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

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode min = new ListNode();
        ListNode max = new ListNode();
        ListNode temp = head;
        ListNode minIndex = min;
        ListNode maxIndex = max;
        while (temp != null) {
            if (temp.val >= x) {
                maxIndex.next = temp;
                maxIndex = maxIndex.next;
            } else {
                minIndex.next = temp;
                minIndex = minIndex.next;
            }
            temp = temp.next;
        }
        maxIndex.next = null;
        minIndex.next = max.next;
        return min.next;
    }
    /**
     * 方法一：模拟
     * 直观来说我们只需维护两个链表 \textit{small}small 和 \textit{large}large 即可，\textit{small}small 链表按顺序存储所有小于 xx 的节点，\textit{large}large 链表按顺序存储所有大于等于 xx 的节点。遍历完原链表后，我们只要将 \textit{small}small 链表尾节点指向 \textit{large}large 链表的头节点即能完成对链表的分隔。
     *
     * 为了实现上述思路，我们设 \textit{smallHead}smallHead 和 \textit{largeHead}largeHead 分别为两个链表的哑节点，即它们的 \textit{next}next 指针指向链表的头节点，这样做的目的是为了更方便地处理头节点为空的边界条件。同时设 \textit{small}small 和 \textit{large}large 节点指向当前链表的末尾节点。开始时 \textit{smallHead}=\textit{small},\textit{largeHead}=\textit{large}smallHead=small,largeHead=large。随后，从前往后遍历链表，判断当前链表的节点值是否小于 xx，如果小于就将 \textit{small}small 的 \textit{next}next 指针指向该节点，否则将 \textit{large}large 的 \textit{next}next 指针指向该节点。
     *
     * 遍历结束后，我们将 \textit{large}large 的 \textit{next}next 指针置空，这是因为当前节点复用的是原链表的节点，而其 \textit{next}next 指针可能指向一个小于 xx 的节点，我们需要切断这个引用。同时将 \textit{small}small 的 \textit{next}next 指针指向 \textit{largeHead}largeHead 的 \textit{next}next 指针指向的节点，即真正意义上的 \textit{large}large 链表的头节点。最后返回 \textit{smallHead}smallHead 的 \textit{next}next 指针即为我们要求的答案。
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     public ListNode partition(ListNode head, int x) {
     *         ListNode small = new ListNode(0);
     *         ListNode smallHead = small;
     *         ListNode large = new ListNode(0);
     *         ListNode largeHead = large;
     *         while (head != null) {
     *             if (head.val < x) {
     *                 small.next = head;
     *                 small = small.next;
     *             } else {
     *                 large.next = head;
     *                 large = large.next;
     *             }
     *             head = head.next;
     *         }
     *         large.next = null;
     *         small.next = largeHead.next;
     *         return smallHead.next;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度: O(n)O(n)，其中 nn 是原链表的长度。我们对该链表进行了一次遍历。
     *
     * 空间复杂度: O(1)O(1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode-solution-7ade/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
