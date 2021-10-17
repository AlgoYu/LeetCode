package cn.machine.geek;

import java.util.Stack;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/17 11:23 上午
 * @Email 794763733@qq.com
 */
public class 二叉搜索树中第K小的元素 {
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

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return -1;
    }

}
