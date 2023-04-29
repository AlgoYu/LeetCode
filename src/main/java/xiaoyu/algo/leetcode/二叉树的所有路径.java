package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class 二叉树的所有路径 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
    /**
     * 方法一：深度优先搜索
     * 思路与算法
     *
     * 最直观的方法是使用深度优先搜索。在深度优先搜索遍历二叉树时，我们需要考虑当前的节点以及它的孩子节点。
     *
     * 如果当前节点不是叶子节点，则在当前的路径末尾添加该节点，并继续递归遍历该节点的每一个孩子节点。
     * 如果当前节点是叶子节点，则在当前路径末尾添加该节点后我们就得到了一条从根节点到叶子节点的路径，将该路径加入到答案即可。
     * 如此，当遍历完整棵二叉树以后我们就得到了所有从根节点到叶子节点的路径。当然，深度优先搜索也可以使用非递归的方式实现，这里不再赘述。
     *
     * 代码
     *
     * C++JavaScriptJavaPythonGolangC
     *
     * class Solution {
     *     public List<String> binaryTreePaths(TreeNode root) {
     *         List<String> paths = new ArrayList<String>();
     *         constructPaths(root, "", paths);
     *         return paths;
     *     }
     *
     *     public void constructPaths(TreeNode root, String path, List<String> paths) {
     *         if (root != null) {
     *             StringBuffer pathSB = new StringBuffer(path);
     *             pathSB.append(Integer.toString(root.val));
     *             if (root.left == null && root.right == null) {  // 当前节点是叶子节点
     *                 paths.add(pathSB.toString());  // 把路径加入到答案中
     *             } else {
     *                 pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
     *                 constructPaths(root.left, pathSB.toString(), paths);
     *                 constructPaths(root.right, pathSB.toString(), paths);
     *             }
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N^2)O(N
     * 2
     *  )，其中 NN 表示节点数目。在深度优先搜索中每个节点会被访问一次且只会被访问一次，每一次会对 path 变量进行拷贝构造，时间代价为 O(N)O(N)，故时间复杂度为 O(N^2)O(N
     * 2
     *  )。
     *
     * 空间复杂度：O(N^2)O(N
     * 2
     *  )，其中 NN 表示节点数目。除答案数组外我们需要考虑递归调用的栈空间。在最坏情况下，当二叉树中每个节点只有一个孩子节点时，即整棵二叉树呈一个链状，此时递归的层数为 NN，此时每一层的 path 变量的空间代价的总和为 O(\sum_{i = 1}^{N} i) = O(N^2)O(∑
     * i=1
     * N
     * ​
     *  i)=O(N
     * 2
     *  ) 空间复杂度为 O(N^2)O(N
     * 2
     *  )。最好情况下，当二叉树为平衡二叉树时，它的高度为 \log NlogN，此时空间复杂度为 O((\log {N})^2)O((logN)
     * 2
     *  )。
     *
     * 方法二：广度优先搜索
     * 思路与算法
     *
     * 我们也可以用广度优先搜索来实现。我们维护一个队列，存储节点以及根到该节点的路径。一开始这个队列里只有根节点。在每一步迭代中，我们取出队列中的首节点，如果它是叶子节点，则将它对应的路径加入到答案中。如果它不是叶子节点，则将它的所有孩子节点加入到队列的末尾。当队列为空时广度优先搜索结束，我们即能得到答案。
     *
     *
     * 1 / 12
     *
     * 代码
     *
     * C++JavaScriptJavaPythonGolangC
     *
     * class Solution {
     *     public List<String> binaryTreePaths(TreeNode root) {
     *         List<String> paths = new ArrayList<String>();
     *         if (root == null) {
     *             return paths;
     *         }
     *         Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
     *         Queue<String> pathQueue = new LinkedList<String>();
     *
     *         nodeQueue.offer(root);
     *         pathQueue.offer(Integer.toString(root.val));
     *
     *         while (!nodeQueue.isEmpty()) {
     *             TreeNode node = nodeQueue.poll();
     *             String path = pathQueue.poll();
     *
     *             if (node.left == null && node.right == null) {
     *                 paths.add(path);
     *             } else {
     *                 if (node.left != null) {
     *                     nodeQueue.offer(node.left);
     *                     pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
     *                 }
     *
     *                 if (node.right != null) {
     *                     nodeQueue.offer(node.right);
     *                     pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
     *                 }
     *             }
     *         }
     *         return paths;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N^2)O(N
     * 2
     *  )，其中 NN 表示节点数目。分析同方法一。
     * 空间复杂度：O(N^2)O(N
     * 2
     *  )，其中 NN 表示节点数目。在最坏情况下，队列中会存在 NN 个节点，保存字符串的队列中每个节点的最大长度为 NN，故空间复杂度为 O(N^2)O(N
     * 2
     *  )。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
