package xiaoyu.algo.leetcode;

import java.util.List;

public class 反转链表II {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode virtual = new ListNode();
        virtual.next = head;

        ListNode slow = virtual;

        for (int i = 0; i < left - 1; i++) {
            if (slow != null) {
                slow = slow.next;
            }
        }

        ListNode fast = slow;

        for (int i = 0; fast != null && i < right - left + 1; i++) {
            fast = fast.next;
        }

        ListNode nextHead = slow.next;
        ListNode nextTail = fast.next;
        slow.next = null;
        fast.next = null;

        ListNode reverse = reverse(nextHead);
        slow.next = fast;
        nextHead.next = nextTail;
        return virtual.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
