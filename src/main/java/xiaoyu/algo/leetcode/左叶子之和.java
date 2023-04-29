package xiaoyu.algo.leetcode;

/**
 * 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class 左叶子之和 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (root.left == null ? 0 : sum(root, root.left)) + (root.right == null ? 0 : sum(root, root.right));
    }

    private int sum(TreeNode parent, TreeNode node) {
        if (node.left == null && node.right == null) {
            return parent.left == node ? node.val : 0;
        }
        int total = 0;
        if (node.left != null) {
            total += sum(node, node.left);
        }
        if (node.right != null) {
            total += sum(node, node.right);
        }
        return total;
    }

    /**
     * 前言
     * 一个节点为「左叶子」节点，当且仅当它是某个节点的左子节点，并且它是一个叶子结点。因此我们可以考虑对整棵树进行遍历，当我们遍历到节点 \textit{node}node 时，如果它的左子节点是一个叶子结点，那么就将它的左子节点的值累加计入答案。
     *
     * 遍历整棵树的方法有深度优先搜索和广度优先搜索，下面分别给出了实现代码。
     *
     * 方法一：深度优先搜索
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public int sumOfLeftLeaves(TreeNode root) {
     *         return root != null ? dfs(root) : 0;
     *     }
     *
     *     public int dfs(TreeNode node) {
     *         int ans = 0;
     *         if (node.left != null) {
     *             ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
     *         }
     *         if (node.right != null && !isLeafNode(node.right)) {
     *             ans += dfs(node.right);
     *         }
     *         return ans;
     *     }
     *
     *     public boolean isLeafNode(TreeNode node) {
     *         return node.left == null && node.right == null;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是树中的节点个数。
     *
     * 空间复杂度：O(n)O(n)。空间复杂度与深度优先搜索使用的栈的最大深度相关。在最坏的情况下，树呈现链式结构，深度为 O(n)O(n)，对应的空间复杂度也为 O(n)O(n)。
     *
     * 方法二：广度优先搜索
     * C++C++17JavaPython3GolangC
     *
     * class Solution {
     *     public int sumOfLeftLeaves(TreeNode root) {
     *         if (root == null) {
     *             return 0;
     *         }
     *
     *         Queue<TreeNode> queue = new LinkedList<TreeNode>();
     *         queue.offer(root);
     *         int ans = 0;
     *         while (!queue.isEmpty()) {
     *             TreeNode node = queue.poll();
     *             if (node.left != null) {
     *                 if (isLeafNode(node.left)) {
     *                     ans += node.left.val;
     *                 } else {
     *                     queue.offer(node.left);
     *                 }
     *             }
     *             if (node.right != null) {
     *                 if (!isLeafNode(node.right)) {
     *                     queue.offer(node.right);
     *                 }
     *             }
     *         }
     *         return ans;
     *     }
     *
     *     public boolean isLeafNode(TreeNode node) {
     *         return node.left == null && node.right == null;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是树中的节点个数。
     *
     * 空间复杂度：O(n)O(n)。空间复杂度与广度优先搜索使用的队列需要的容量相关，为 O(n)O(n)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
