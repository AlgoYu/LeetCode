package xiaoyu.algo.leetcode;

public class 从根到叶的二进制数之和 {
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

    private int num;

    public int sumRootToLeaf(TreeNode root) {
        num = 0;
        preOrder(root, new StringBuilder());
        return num;
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            int value = Integer.parseInt(sb.toString(), 2);
            num += value;
        } else {
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
        sb.delete(sb.length() - 1, sb.length());
    }
}
