package xiaoyu.algo.leetcode;

public class 二叉树中的最大路径和 {
    public static class TreeNode {
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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lv = Math.max(postOrder(root.left), 0);
        int rv = Math.max(postOrder(root.right), 0);
        max = Math.max(max, lv + rv + root.val);
        return Math.max(lv, rv) + root.val;
    }
}
