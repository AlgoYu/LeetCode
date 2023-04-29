package xiaoyu.algo.leetcode;

public class 二叉树的坡度 {

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

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = sum(root.left);
        int rightValue = sum(root.right);
        return Math.abs(leftValue - rightValue) + findTilt(root.left) + findTilt(root.right);
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
