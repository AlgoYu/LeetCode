package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

public class 键值映射 {
    class Node {
        String key;
        int value;
        boolean end;
        Map<Character, Node> child = new HashMap<>();
    }

    Node root;

    public 键值映射() {
        root = new Node();
    }

    public void insert(String key, int val) {
        if (check(key)) {
            return;
        }
        int n = key.length();
        Node cur = root;
        for (int i = 0; i < n; i++) {
            char c = key.charAt(i);
            Node temp = cur.child.get(c);
            if (temp == null) {
                temp = new Node();
                cur.child.put(c, temp);
            }
            cur = temp;
        }
        cur.end = true;
        cur.key = key;
        cur.value = val;
    }

    public int sum(String prefix) {
        if (check(prefix)) {
            return 0;
        }
        int n = prefix.length();
        Node cur = root;
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            Node temp = cur.child.get(c);
            if (temp == null) {
                return 0;
            }
            cur = temp;
        }
        return count(cur);
    }

    private int count(Node node) {
        if (node == null) {
            return 0;
        }
        int sum = node.end ? node.value : 0;
        for (Node child : node.child.values()) {
            sum += count(child);
        }
        return sum;
    }

    private boolean check(String key) {
        return key == null || key.length() == 0;
    }
}
