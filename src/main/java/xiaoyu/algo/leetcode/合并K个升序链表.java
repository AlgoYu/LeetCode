package xiaoyu.algo.leetcode;

public class 合并K个升序链表 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode cur = result;
        for (; ; ) {
            ListNode min = null;
            int swapIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    min = compareNode(min, node);
                    if (min == node) {
                        swapIndex = i;
                    }
                }
            }
            if (min == null) {
                return result.next;
            }
            cur.next = min;
            cur = cur.next;
            lists[swapIndex] = lists[swapIndex].next;
        }
    }

    private ListNode compareNode(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        return node1.val > node2.val ? node2 : node1;
    }
}
