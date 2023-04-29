package xiaoyu.algo.leetcode;

/**
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class 二叉树的最小深度 {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
    /**
     * 方法一：深度优先搜索
     * 思路及解法
     *
     * 首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。
     *
     * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题。
     *
     * 代码
     *
     * C++JavaCPython3Golang
     *
     * class Solution {
     *     public int minDepth(TreeNode root) {
     *         if (root == null) {
     *             return 0;
     *         }
     *
     *         if (root.left == null && root.right == null) {
     *             return 1;
     *         }
     *
     *         int min_depth = Integer.MAX_VALUE;
     *         if (root.left != null) {
     *             min_depth = Math.min(minDepth(root.left), min_depth);
     *         }
     *         if (root.right != null) {
     *             min_depth = Math.min(minDepth(root.right), min_depth);
     *         }
     *
     *         return min_depth + 1;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是树的节点数。对每个节点访问一次。
     *
     * 空间复杂度：O(H)O(H)，其中 HH 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)O(N)。平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(\log N)O(logN)。
     *
     * 方法二：广度优先搜索
     * 思路及解法
     *
     * 同样，我们可以想到使用广度优先搜索的方法，遍历整棵树。
     *
     * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
     *
     * 代码
     *
     * C++JavaCPython3Golang
     *
     * class Solution {
     *     class QueueNode {
     *         TreeNode node;
     *         int depth;
     *
     *         public QueueNode(TreeNode node, int depth) {
     *             this.node = node;
     *             this.depth = depth;
     *         }
     *     }
     *
     *     public int minDepth(TreeNode root) {
     *         if (root == null) {
     *             return 0;
     *         }
     *
     *         Queue<QueueNode> queue = new LinkedList<QueueNode>();
     *         queue.offer(new QueueNode(root, 1));
     *         while (!queue.isEmpty()) {
     *             QueueNode nodeDepth = queue.poll();
     *             TreeNode node = nodeDepth.node;
     *             int depth = nodeDepth.depth;
     *             if (node.left == null && node.right == null) {
     *                 return depth;
     *             }
     *             if (node.left != null) {
     *                 queue.offer(new QueueNode(node.left, depth + 1));
     *             }
     *             if (node.right != null) {
     *                 queue.offer(new QueueNode(node.right, depth + 1));
     *             }
     *         }
     *
     *         return 0;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是树的节点数。对每个节点访问一次。
     *
     * 空间复杂度：O(N)O(N)，其中 NN 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/er-cha-shu-de-zui-xiao-shen-du-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
