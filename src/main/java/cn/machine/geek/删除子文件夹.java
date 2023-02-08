package cn.machine.geek;

import java.util.*;

public class 删除子文件夹 {
    class Node {
        boolean flag;
        String name;
        Map<String, Node> child;

        public Node() {
            child = new HashMap<>();
            flag = false;
        }

        public void addFolder(String folder) {
            String[] paths = folder.split("/");
            Node cur = this;
            for (String path : paths) {
                cur = cur.child.computeIfAbsent(path, k -> new Node());
            }
            cur.flag = true;
            cur.name = folder;
        }

        public List<String> getAllFirstFold() {
            Node cur = this;
            Queue<Node> queue = new LinkedList<>();
            List<String> data = new ArrayList<>();
            queue.offer(cur);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (poll.flag) {
                    data.add(poll.name);
                    continue;
                }
                if (poll.child.size() > 0) {
                    queue.addAll(poll.child.values());
                }
            }
            return data;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        for (String fold : folder) {
            root.addFolder(fold);
        }
        return root.getAllFirstFold();
    }
}
