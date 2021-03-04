package cn.machine.geek;

/**
 * @Author: MachineGeek
 * @Description:
 * @Email: 794763733@qq.com
 * @Date: 2021/3/4
 */
public class Main {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode temp = head;
        int n = 1;
        while (temp.next != null){
            temp = temp.next;
            n++;
        }
        temp.next = head;

        temp = head;
        for (int i = 0; i < n - k % n - 1; i++){
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }
    /**
     * 方法 1：
     * 直觉
     *
     * 链表中的点已经相连，一次旋转操作意味着：
     *
     * 先将链表闭合成环
     * 找到相应的位置断开这个环，确定新的链表头和链表尾
     *
     *
     * 新的链表头在哪里？
     *
     * 在位置 n-k 处，其中 n 是链表中点的个数，新的链表尾就在头的前面，位于位置 n-k-1。
     *
     * 我们这里假设 k < n
     *
     * 如果 k >= n 怎么处理？
     *
     * k 可以被写成 k = (k // n) * n + k % n 两者加和的形式，其中前面的部分不影响最终的结果，因此只需要考虑 k%n 的部分，这个值一定比 n 小。
     *
     * 算法
     *
     * 算法实现很直接：
     *
     * 找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     * 找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     * 断开环 new_tail.next = None，并返回新的链表头 new_head。
     * 实现
     *
     *
     * 1 / 14
     *
     * JavaPython
     *
     * class Solution {
     *   public ListNode rotateRight(ListNode head, int k) {
     *     // base cases
     *     if (head == null) return null;
     *     if (head.next == null) return head;
     *
     *     // close the linked list into the ring
     *     ListNode old_tail = head;
     *     int n;
     *     for(n = 1; old_tail.next != null; n++)
     *       old_tail = old_tail.next;
     *     old_tail.next = head;
     *
     *     // find new tail : (n - k % n - 1)th node
     *     // and new head : (n - k % n)th node
     *     ListNode new_tail = head;
     *     for (int i = 0; i < n - k % n - 1; i++)
     *       new_tail = new_tail.next;
     *     ListNode new_head = new_tail.next;
     *
     *     // break the ring
     *     new_tail.next = null;
     *
     *     return new_head;
     *   }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是链表中的元素个数
     * 空间复杂度：O(1)O(1)，因为只需要常数的空间
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
