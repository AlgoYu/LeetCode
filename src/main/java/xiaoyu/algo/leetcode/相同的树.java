package xiaoyu.algo.leetcode;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class 相同的树 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    /**
     * 前言
     * 两个二叉树相同，当且仅当两个二叉树的结构完全相同，且所有对应节点的值相同。因此，可以通过搜索的方式判断两个二叉树是否相同。
     *
     * 方法一：深度优先搜索
     * 如果两个二叉树都为空，则两个二叉树相同。如果两个二叉树中有且只有一个为空，则两个二叉树一定不相同。
     *
     * 如果两个二叉树都不为空，那么首先判断它们的根节点的值是否相同，若不相同则两个二叉树一定不同，若相同，再分别判断两个二叉树的左子树是否相同以及右子树是否相同。这是一个递归的过程，因此可以使用深度优先搜索，递归地判断两个二叉树是否相同。
     *
     *
     * 1 / 6
     *
     * JavaPython3C++CGolang
     *
     * class Solution {
     *     public boolean isSameTree(TreeNode p, TreeNode q) {
     *         if (p == null && q == null) {
     *             return true;
     *         } else if (p == null || q == null) {
     *             return false;
     *         } else if (p.val != q.val) {
     *             return false;
     *         } else {
     *             return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
     *
     * 空间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
     *
     * 方法二：广度优先搜索
     * 也可以通过广度优先搜索判断两个二叉树是否相同。同样首先判断两个二叉树是否为空，如果两个二叉树都不为空，则从两个二叉树的根节点开始广度优先搜索。
     *
     * 使用两个队列分别存储两个二叉树的节点。初始时将两个二叉树的根节点分别加入两个队列。每次从两个队列各取出一个节点，进行如下比较操作。
     *
     * 比较两个节点的值，如果两个节点的值不相同则两个二叉树一定不同；
     *
     * 如果两个节点的值相同，则判断两个节点的子节点是否为空，如果只有一个节点的左子节点为空，或者只有一个节点的右子节点为空，则两个二叉树的结构不同，因此两个二叉树一定不同；
     *
     * 如果两个节点的子节点的结构相同，则将两个节点的非空子节点分别加入两个队列，子节点加入队列时需要注意顺序，如果左右子节点都不为空，则先加入左子节点，后加入右子节点。
     *
     * 如果搜索结束时两个队列同时为空，则两个二叉树相同。如果只有一个队列为空，则两个二叉树的结构不同，因此两个二叉树不同。
     *
     * JavaPythonC++CGolang
     *
     * class Solution {
     *     public boolean isSameTree(TreeNode p, TreeNode q) {
     *         if (p == null && q == null) {
     *             return true;
     *         } else if (p == null || q == null) {
     *             return false;
     *         }
     *         Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
     *         Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
     *         queue1.offer(p);
     *         queue2.offer(q);
     *         while (!queue1.isEmpty() && !queue2.isEmpty()) {
     *             TreeNode node1 = queue1.poll();
     *             TreeNode node2 = queue2.poll();
     *             if (node1.val != node2.val) {
     *                 return false;
     *             }
     *             TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
     *             if (left1 == null ^ left2 == null) {
     *                 return false;
     *             }
     *             if (right1 == null ^ right2 == null) {
     *                 return false;
     *             }
     *             if (left1 != null) {
     *                 queue1.offer(left1);
     *             }
     *             if (right1 != null) {
     *                 queue1.offer(right1);
     *             }
     *             if (left2 != null) {
     *                 queue2.offer(left2);
     *             }
     *             if (right2 != null) {
     *                 queue2.offer(right2);
     *             }
     *         }
     *         return queue1.isEmpty() && queue2.isEmpty();
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。对两个二叉树同时进行广度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
     *
     * 空间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。空间复杂度取决于队列中的元素个数，队列中的元素个数不会超过较小的二叉树的节点数。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/same-tree/solution/xiang-tong-de-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
