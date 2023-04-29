package xiaoyu.algo.leetcode;

public class 合并两个链表 {

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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        int n = 0;
        while (cur.next != null && n < a - 1) {
            cur = cur.next;
            n++;
        }
        ListNode break1 = cur;
        while (cur.next != null && n <= b) {
            cur = cur.next;
            n++;
        }
        break1.next = list2;
        lastNode(list2).next = cur;
        return list1;
    }

    public ListNode lastNode(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
