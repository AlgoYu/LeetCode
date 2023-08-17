package xiaoyu.algo.leetcode;

public class 删除排序链表中的重复元素II {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode virtual = new ListNode();
        ListNode node = head;
        ListNode cur = virtual;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int val = node.val;
                while (node != null && node.val == val) {
                    node = node.next;
                }
            } else {
                cur.next = node;
                cur = cur.next;
                node = node.next;
            }
        }
        cur.next = null;
        return virtual.next;
    }
}
