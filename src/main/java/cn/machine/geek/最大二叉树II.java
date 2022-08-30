package cn.machine.geek;

public class 最大二叉树II {
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                parent.right = new TreeNode(val, cur, null);
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (parent != null) {
            parent.right = new TreeNode(val);
        }
        return root;
    }
}
