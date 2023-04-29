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
        // 前序遍历，每一个节点都作为根。
        total += count(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return total;
    }

    public int count(TreeNode root, int targetSum) {
        int num = 0;
        if (root == null) {
            return num;
        }
        if (root.val == targetSum) {
            num++;
            // 不应该退出，还有向下反复添加成为这个数值的可能性
        }
        num += count(root.left, targetSum - root.val);
        num += count(root.right, targetSum - root.val);
        return num;
    }
}
