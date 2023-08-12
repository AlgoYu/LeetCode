package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/28 12:42 下午
 * @Email 794763733@qq.com
 */
public class 路径总和III {
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

    int total;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return total;
        }
        stat(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return total;
    }

    public void stat(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum) {
            total++;
        }
        stat(root.left, targetSum - root.val);
        stat(root.right, targetSum - root.val);
    }
}
