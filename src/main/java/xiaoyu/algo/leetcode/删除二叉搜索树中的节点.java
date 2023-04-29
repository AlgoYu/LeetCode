package xiaoyu.algo.leetcode;

public class 删除二叉搜索树中的节点 {

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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tmp = root;
        TreeNode parent = null;
        // 左右查找节点
        while (tmp != null) {
            if (tmp.val == key) {
                break;
            }
            parent = tmp;
            if (key > tmp.val) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }
        // 没找到
        if (tmp == null) {
            return root;
        }
        if (tmp.left == null && tmp.right == null) {
            tmp = null;
        } else if (tmp.left == null) {
            tmp = tmp.right;
        } else if (tmp.right == null) {
            tmp = tmp.left;
        } else {
            TreeNode successor = tmp.right, successorParent = tmp;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == tmp.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = tmp.right;
            successor.left = tmp.left;
            tmp = successor;
        }
        if (parent == null) {
            return tmp;
        }
        // 删除节点
        if (parent.left != null && parent.left.val == key) {
            parent.left = tmp;
        } else {
            parent.right = tmp;
        }
        return root;
    }
}
