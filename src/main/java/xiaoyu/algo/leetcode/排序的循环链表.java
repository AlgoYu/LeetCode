package xiaoyu.algo.leetcode;

public class 排序的循环链表 {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node cur = head, next = head.next;
        while (next != head) {
            if (cur.val <= insertVal && insertVal <= next.val) {
                break;
            }
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }
}
