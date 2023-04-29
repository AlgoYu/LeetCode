package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class 二叉树的前序遍历 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp == null) tmp = stack.pop();
            result.add(tmp.val);
            if (tmp.right != null) stack.push(tmp.right);
            tmp = tmp.left;
        }
        return result;
    }
    /**
     * 方法一：递归
     * 思路与算法
     *
     * 首先我们需要了解什么是二叉树的前序遍历：按照访问根节点——左子树——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候，我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。
     *
     * 定义 preorder(root) 表示当前遍历到 root 节点的答案。按照定义，我们只要首先将 root 节点的值加入答案，然后递归调用 preorder(root.left) 来遍历 root 节点的左子树，最后递归调用 preorder(root.right) 来遍历 root 节点的右子树即可，递归终止的条件为碰到空节点。
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public List<Integer> preorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         preorder(root, res);
     *         return res;
     *     }
     *
     *     public void preorder(TreeNode root, List<Integer> res) {
     *         if (root == null) {
     *             return;
     *         }
     *         res.add(root.val);
     *         preorder(root.left, res);
     *         preorder(root.right, res);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉树的节点数。每一个节点恰好被遍历一次。
     *
     * 空间复杂度：O(n)O(n)，为递归过程中栈的开销，平均情况下为 O(\log n)O(logn)，最坏情况下树呈现链状，为 O(n)O(n)。
     *
     * 方法二：迭代
     * 思路与算法
     *
     * 我们也可以用迭代的方式实现方法一的递归函数，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来，其余的实现与细节都相同，具体可以参考下面的代码。
     *
     *
     * 1 / 14
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public List<Integer> preorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         if (root == null) {
     *             return res;
     *         }
     *
     *         Deque<TreeNode> stack = new LinkedList<TreeNode>();
     *         TreeNode node = root;
     *         while (!stack.isEmpty() || node != null) {
     *             while (node != null) {
     *                 res.add(node.val);
     *                 stack.push(node);
     *                 node = node.left;
     *             }
     *             node = stack.pop();
     *             node = node.right;
     *         }
     *         return res;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉树的节点数。每一个节点恰好被遍历一次。
     *
     * 空间复杂度：O(n)O(n)，为迭代过程中显式栈的开销，平均情况下为 O(\log n)O(logn)，最坏情况下树呈现链状，为 O(n)O(n)。
     *
     * 方法三：Morris 遍历
     * 思路与算法
     *
     * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现前序遍历。这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
     *
     * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其前序遍历规则总结如下：
     *
     * 新建临时节点，令该节点为 root；
     *
     * 如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点；
     *
     * 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
     *
     * 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，并将前驱节点的右子节点更新为当前节点。当前节点更新为当前节点的左子节点。
     *
     * 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。当前节点更新为当前节点的右子节点。
     *
     * 重复步骤 2 和步骤 3，直到遍历结束。
     *
     * 这样我们利用 Morris 遍历的方法，前序遍历该二叉树，即可实现线性时间与常数空间的遍历。
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public List<Integer> preorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         if (root == null) {
     *             return res;
     *         }
     *
     *         TreeNode p1 = root, p2 = null;
     *
     *         while (p1 != null) {
     *             p2 = p1.left;
     *             if (p2 != null) {
     *                 while (p2.right != null && p2.right != p1) {
     *                     p2 = p2.right;
     *                 }
     *                 if (p2.right == null) {
     *                     res.add(p1.val);
     *                     p2.right = p1;
     *                     p1 = p1.left;
     *                     continue;
     *                 } else {
     *                     p2.right = null;
     *                 }
     *             } else {
     *                 res.add(p1.val);
     *             }
     *             p1 = p1.right;
     *         }
     *         return res;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉树的节点数。没有左子树的节点只被访问一次，有左子树的节点被访问两次。
     *
     * 空间复杂度：O(1)O(1)。只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
