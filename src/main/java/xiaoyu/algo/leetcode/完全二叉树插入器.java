package xiaoyu.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class 完全二叉树插入器 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Queue<TreeNode> candidate;
    TreeNode root;

    public 完全二叉树插入器(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left == null || node.right == null) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
}
