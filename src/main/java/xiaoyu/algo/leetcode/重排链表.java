package xiaoyu.algo.leetcode;

public class 重排链表 {

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

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (slow.next == null) {
            return;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode reverse = reverse(next);
        ListNode virtual = new ListNode();
        ListNode cur = virtual;
        while (head != null && reverse != null) {
            cur.next = head;
            cur = cur.next;
            head = head.next;
            cur.next = reverse;
            reverse = reverse.next;
            cur = cur.next;
        }
        cur.next = head == null ? reverse : head;
    }

    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
