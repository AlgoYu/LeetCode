package cn.machine.geek;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化和反序列化二叉搜索树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                sb.append("N,");
                continue;
            }
            sb.append(poll.val).append(",");
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = parseTreeNode(split[0]);
        queue.offer(root);
        int index = 1;
        while (index < split.length) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            poll.left = parseTreeNode(split[index++]);
            poll.right = parseTreeNode(split[index++]);
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return root;
    }

    private TreeNode parseTreeNode(String s) {
        if (s == null || "N".equals(s)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(s));
    }
}
