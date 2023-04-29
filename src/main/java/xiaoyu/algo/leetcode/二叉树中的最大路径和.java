package xiaoyu.algo.leetcode;

/**
 * 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
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

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    public int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, postOrder(node.left));
        int right = Math.max(0, postOrder(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    /**
     * 二叉树中的最大路径和
     * 力扣官方题解
     * 发布于 2020-06-20
     * 93.4k
     * 📺 视频题解
     *
     * 📖 文字题解
     * 方法一：递归
     * 首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
     *
     * 具体而言，该函数的计算如下。
     *
     * 空节点的最大贡献值等于 00。
     *
     * 非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
     *
     * 例如，考虑如下二叉树。
     *
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 叶节点 99、1515、77 的最大贡献值分别为 99、1515、77。
     *
     * 得到叶节点的最大贡献值之后，再计算非叶节点的最大贡献值。节点 2020 的最大贡献值等于 20+\max(15,7)=3520+max(15,7)=35，节点 -10−10 的最大贡献值等于 -10+\max(9,35)=25−10+max(9,35)=25。
     *
     * 上述计算过程是递归的过程，因此，对根节点调用函数 maxGain，即可得到每个节点的最大贡献值。
     *
     * 根据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和。维护一个全局变量 maxSum 存储最大路径和，在递归过程中更新 maxSum 的值，最后得到的 maxSum 的值即为二叉树中的最大路径和。
     *
     *
     *
     *
     * class Solution {
     *     int maxSum = Integer.MIN_VALUE;
     *
     *     public int maxPathSum(TreeNode root) {
     *         maxGain(root);
     *         return maxSum;
     *     }
     *
     *     public int maxGain(TreeNode node) {
     *         if (node == null) {
     *             return 0;
     *         }
     *
     *         // 递归计算左右子节点的最大贡献值
     *         // 只有在最大贡献值大于 0 时，才会选取对应子节点
     *         int leftGain = Math.max(maxGain(node.left), 0);
     *         int rightGain = Math.max(maxGain(node.right), 0);
     *
     *         // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
     *         int priceNewpath = node.val + leftGain + rightGain;
     *
     *         // 更新答案
     *         maxSum = Math.max(maxSum, priceNewpath);
     *
     *         // 返回节点的最大贡献值
     *         return node.val + Math.max(leftGain, rightGain);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是二叉树中的节点个数。对每个节点访问不超过 22 次。
     *
     * 空间复杂度：O(N)O(N)，其中 NN 是二叉树中的节点个数。空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，最坏情况下，二叉树的高度等于二叉树中的节点个数。
     */
}
