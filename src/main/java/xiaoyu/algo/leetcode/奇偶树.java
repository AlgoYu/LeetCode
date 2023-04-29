package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class 奇偶树 {

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

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层
        int level = 0;
        while (!queue.isEmpty()) {
            // 偶数
            boolean flag = (level & 1) == 0;
            int n = queue.size();
            TreeNode pre = null;
            while (n > 0) {
                TreeNode node = queue.poll();
                // 偶数层
                if (flag) {
                    // 是偶数或者大于之前的数
                    if ((node.val & 1) == 0 || (pre != null && node.val <= pre.val)) {
                        return false;
                    }
                }
                // 奇数
                if (!flag) {
                    // 是奇数或者小于之前的数
                    if ((node.val & 1) == 1 || (pre != null && node.val >= pre.val)) {
                        return false;
                    }
                }
                // 左右节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                n--;
                pre = node;
            }
            level++;
        }
        return true;
    }
}
