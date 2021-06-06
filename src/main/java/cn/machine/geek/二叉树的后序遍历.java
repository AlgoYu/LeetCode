package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/6/6 6:38 下午
 * @Email 794763733@qq.com
 */
public class 二叉树的后序遍历 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        return traversal(new ArrayList<>(), root);
    }

    public List<Integer> traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return list;
        }
        traversal(list, node.left);
        traversal(list, node.right);
        list.add(node.val);
        return list;
    }
    /**
     * 方法一：递归
     * 思路与算法
     *
     * 首先我们需要了解什么是二叉树的后序遍历：按照访问左子树——右子树——根节点的方式遍历这棵树，而在访问左子树或者右子树的时候，我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。
     *
     * 定义 postorder(root) 表示当前遍历到 root 节点的答案。按照定义，我们只要递归调用 postorder(root->left) 来遍历 root 节点的左子树，然后递归调用 postorder(root->right) 来遍历 root 节点的右子树，最后将 root 节点的值加入答案即可，递归终止的条件为碰到空节点。
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public List<Integer> postorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         postorder(root, res);
     *         return res;
     *     }
     *
     *     public void postorder(TreeNode root, List<Integer> res) {
     *         if (root == null) {
     *             return;
     *         }
     *         postorder(root.left, res);
     *         postorder(root.right, res);
     *         res.add(root.val);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉搜索树的节点数。每一个节点恰好被遍历一次。
     *
     * 空间复杂度：O(n)O(n)，为递归过程中栈的开销，平均情况下为 O(\log n)O(logn)，最坏情况下树呈现链状，为 O(n)O(n)。
     *
     * 方法二：迭代
     * 思路与算法
     *
     * 我们也可以用迭代的方式实现方法一的递归函数，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来，其余的实现与细节都相同，具体可以参考下面的代码。
     *
     *
     * 1 / 19
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public List<Integer> postorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         if (root == null) {
     *             return res;
     *         }
     *
     *         Deque<TreeNode> stack = new LinkedList<TreeNode>();
     *         TreeNode prev = null;
     *         while (root != null || !stack.isEmpty()) {
     *             while (root != null) {
     *                 stack.push(root);
     *                 root = root.left;
     *             }
     *             root = stack.pop();
     *             if (root.right == null || root.right == prev) {
     *                 res.add(root.val);
     *                 prev = root;
     *                 root = null;
     *             } else {
     *                 stack.push(root);
     *                 root = root.right;
     *             }
     *         }
     *         return res;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉搜索树的节点数。每一个节点恰好被遍历一次。
     *
     * 空间复杂度：O(n)O(n)，为迭代过程中显式栈的开销，平均情况下为 O(\log n)O(logn)，最坏情况下树呈现链状，为 O(n)O(n)。
     *
     * 方法三：Morris 遍历
     * 思路与算法
     *
     * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现后序遍历。这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
     *
     * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其后序遍历规则总结如下：
     *
     * 新建临时节点，令该节点为 root；
     *
     * 如果当前节点的左子节点为空，则遍历当前节点的右子节点；
     *
     * 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点；
     *
     * 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，当前节点更新为当前节点的左子节点。
     *
     * 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右子节点。
     *
     * 重复步骤 2 和步骤 3，直到遍历结束。
     *
     * 这样我们利用 Morris 遍历的方法，后序遍历该二叉搜索树，即可实现线性时间与常数空间的遍历。
     *
     * 代码
     *
     * C++JavaPython3GolangC
     *
     * class Solution {
     *     public List<Integer> postorderTraversal(TreeNode root) {
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
     *                     p2.right = p1;
     *                     p1 = p1.left;
     *                     continue;
     *                 } else {
     *                     p2.right = null;
     *                     addPath(res, p1.left);
     *                 }
     *             }
     *             p1 = p1.right;
     *         }
     *         addPath(res, root);
     *         return res;
     *     }
     *
     *     public void addPath(List<Integer> res, TreeNode node) {
     *         int count = 0;
     *         while (node != null) {
     *             ++count;
     *             res.add(node.val);
     *             node = node.right;
     *         }
     *         int left = res.size() - count, right = res.size() - 1;
     *         while (left < right) {
     *             int temp = res.get(left);
     *             res.set(left, res.get(right));
     *             res.set(right, temp);
     *             left++;
     *             right--;
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉树的节点数。没有左子树的节点只被访问一次，有左子树的节点被访问两次。
     *
     * 空间复杂度：O(1)O(1)。只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
