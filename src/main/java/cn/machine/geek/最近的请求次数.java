package cn.machine.geek;

public class 最近的请求次数 {

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;

    public 最近的请求次数() {
        head = new Node(Integer.MIN_VALUE, null);
    }

    public int ping(int t) {
        head.next = new Node(t, head.next);
        Node temp = head.next;
        int n = 0;
        while (temp != null && temp.val >= t - 3000) {
            temp = temp.next;
            n++;
        }
        if (temp != null) {
            temp.next = null;
        }
        return n;
    }
}
