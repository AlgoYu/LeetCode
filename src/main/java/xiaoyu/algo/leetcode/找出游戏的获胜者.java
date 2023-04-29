package xiaoyu.algo.leetcode;

public class 找出游戏的获胜者 {
    public int findTheWinner(int n, int k) {
        Node first = new Node(1, null);
        Node temp = first;
        for (int i = 2; i <= n; i++) {
            temp.next = new Node(i, null);
            temp = temp.next;
        }
        temp.next = first;
        while (!first.next.equals(first)) {
            for (int i = 0; i < k - 1; i++) {
                first = first.next;
            }
            first.val = first.next.val;
            first.next = first.next.next;
        }
        return first.val;
    }

    class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
