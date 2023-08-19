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
        ListNode virtual = new ListNode();
        ListNode cur = virtual;
        for (; ; ) {
            ListNode min = null;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (min == null || min.val > lists[i].val) {
                        min = lists[i];
                        index = i;
                    }
                }
            }
            if (index == -1) {
                break;
            }
            cur.next = min;
            cur = cur.next;
            lists[index] = lists[index].next;
            min = null;
        }
        return virtual.next;
    }
}
