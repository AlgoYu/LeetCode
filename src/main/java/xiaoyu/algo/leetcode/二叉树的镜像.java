package xiaoyu.algo.leetcode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class 二叉树的镜像 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        mirrorTree(root.left);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        mirrorTree(root.left);
        return root;
    }
    /**
     * 方法一：递归
     * 思路与算法
     *
     * 这是一道很经典的二叉树问题。显然，我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转得到镜像。如果当前遍历到的节点 \textit{root}root 的左右两棵子树都已经翻转得到镜像，那么我们只需要交换两棵子树的位置，即可得到以 \textit{root}root 为根节点的整棵子树的镜像。
     *
     * 代码
     *
     * C++JavaPython3GolangJavaScriptC
     *
     * class Solution {
     *     public TreeNode mirrorTree(TreeNode root) {
     *         if (root == null) {
     *             return null;
     *         }
     *         TreeNode left = mirrorTree(root.left);
     *         TreeNode right = mirrorTree(root.right);
     *         root.left = right;
     *         root.right = left;
     *         return root;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
     *
     * 空间复杂度：O(N)O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(\log N)O(logN)。而在最坏情况下，树形成链状，空间复杂度为 O(N)O(N)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/er-cha-shu-de-jing-xiang-by-leetcode-sol-z44i/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
