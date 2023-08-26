package xiaoyu.algo.leetcode;

public class 统计二叉树中好节点的数目 {

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

    int result;

    public int goodNodes(TreeNode root) {
        result = 0;
        dfs(root, Integer.MIN_VALUE);
        return result;
    }

    private void dfs(TreeNode root, int parentMax) {
        if (root == null) {
            return;
        }
        if (root.val >= parentMax) {
            result++;
        }
        dfs(root.left, Math.max(root.val, parentMax));
        dfs(root.right, Math.max(root.val, parentMax));
    }
}
