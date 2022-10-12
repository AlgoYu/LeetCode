package cn.machine.geek;

import java.util.HashSet;
import java.util.Set;

public class 链表组件 {

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

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val)) {
                while (cur != null && set.contains(cur.val)) {
                    cur = cur.next;
                }
                size++;
            }
            if (cur != null) {
                cur = cur.next;
            }
        }
        return size;
    }
}
