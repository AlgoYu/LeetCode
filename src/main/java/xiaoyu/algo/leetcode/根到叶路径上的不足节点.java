package xiaoyu.algo.leetcode;

public class 根到叶路径上的不足节点 {

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

    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        deleteNode(root, 0);
        if (root.left == null && root.right == null && root.val < limit) {
            return null;
        }
        return root;
    }

    private boolean deleteNode(TreeNode root, int parent) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return parent + root.val >= limit;
        }
        boolean lv = deleteNode(root.left, root.val + parent);
        boolean rv = deleteNode(root.right, root.val + parent);
        if (!lv) {
            root.left = null;
        }
        if (!rv) {
            root.right = null;
        }
        return lv || rv;
    }

}
