package xiaoyu.algo.leetcode;

public class 合并两个有序链表 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode virtual = new ListNode();
        ListNode cur = virtual;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                cur.next = l1 == null ? l2 : l1;
                break;
            }
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        return virtual.next;
    }
}
