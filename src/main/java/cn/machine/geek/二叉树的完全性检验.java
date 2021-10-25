package cn.machine.geek;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/23 6:17 下午
 * @Email 794763733@qq.com
 */
public class 二叉树的完全性检验 {
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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean complete = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!complete && node.right != null) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                complete = false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                complete = false;
            }
        }
        return true;
    }
}
