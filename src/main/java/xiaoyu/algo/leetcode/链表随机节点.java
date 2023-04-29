package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class 链表随机节点 {
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

    List<ListNode> list;
    Random random;
    int n;

    public 链表随机节点(ListNode head) {
        list = new LinkedList<>();
        while (head != null) {
            ListNode node = head;
            list.add(node);
            head = head.next;
        }
        random = new Random();
        n = list.size();
    }

    public int getRandom() {
        int i = random.nextInt(n);
        return list.get(i).val;
    }
}
