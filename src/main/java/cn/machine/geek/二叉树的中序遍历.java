package cn.machine.geek;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 输出：[2,1]
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
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class 二叉树的中序遍历 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }
    /**
     * 方法一：递归
     * 思路与算法
     *
     * 首先我们需要了解什么是二叉树的中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。
     *
     * 定义 inorder(root) 表示当前遍历到 \textit{root}root 节点的答案，那么按照定义，我们只要递归调用 inorder(root.left) 来遍历 \textit{root}root 节点的左子树，然后将 \textit{root}root 节点的值加入答案，再递归调用inorder(root.right) 来遍历 \textit{root}root 节点的右子树即可，递归终止的条件为碰到空节点。
     *
     * 代码
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     public List<Integer> inorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         inorder(root, res);
     *         return res;
     *     }
     *
     *     public void inorder(TreeNode root, List<Integer> res) {
     *         if (root == null) {
     *             return;
     *         }
     *         inorder(root.left, res);
     *         res.add(root.val);
     *         inorder(root.right, res);
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     *
     * 空间复杂度：O(n)O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n)O(n) 的级别。
     *
     * 方法二：迭代
     * 思路与算法
     *
     * 方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来，其他都相同，具体实现可以看下面的代码。
     *
     *
     * 1 / 14
     *
     * 代码
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     public List<Integer> inorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         Deque<TreeNode> stk = new LinkedList<TreeNode>();
     *         while (root != null || !stk.isEmpty()) {
     *             while (root != null) {
     *                 stk.push(root);
     *                 root = root.left;
     *             }
     *             root = stk.pop();
     *             res.add(root.val);
     *             root = root.right;
     *         }
     *         return res;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     *
     * 空间复杂度：O(n)O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n)O(n) 的级别。
     *
     * 方法三：Morris 中序遍历
     * 思路与算法
     *
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)O(1)。
     *
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：
     *
     * 如果 xx 无左孩子，先将 xx 的值加入答案数组，再访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
     * 如果 xx 有左孩子，则找到 xx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xx 在中序遍历中的前驱节点），我们记为 \textit{predecessor}predecessor。根据 \textit{predecessor}predecessor 的右孩子是否为空，进行如下操作。
     * 如果 \textit{predecessor}predecessor 的右孩子为空，则将其右孩子指向 xx，然后访问 xx 的左孩子，即 x = x.\textit{left}x=x.left。
     * 如果 \textit{predecessor}predecessor 的右孩子不为空，则此时其右孩子指向 xx，说明我们已经遍历完 xx 的左子树，我们将 \textit{predecessor}predecessor 的右孩子置空，将 xx 的值加入答案数组，然后访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
     * 重复上述操作，直至访问完整棵树。
     *
     * 1 / 19
     *
     * 其实整个过程我们就多做一步：假设当前遍历到的节点为 xx，将 xx 的左子树中最右边的节点的右孩子指向 xx，这样在左子树遍历完成后我们通过这个指向走回了 xx，且能通过这个指向知晓我们已经遍历完成了左子树，而不用再通过栈来维护，省去了栈的空间复杂度。
     *
     * 代码
     *
     * C++JavaJavaScriptGolangC
     *
     * class Solution {
     *     public List<Integer> inorderTraversal(TreeNode root) {
     *         List<Integer> res = new ArrayList<Integer>();
     *         TreeNode predecessor = null;
     *
     *         while (root != null) {
     *             if (root.left != null) {
     *                 // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
     *                 predecessor = root.left;
     *                 while (predecessor.right != null && predecessor.right != root) {
     *                     predecessor = predecessor.right;
     *                 }
     *
     *                 // 让 predecessor 的右指针指向 root，继续遍历左子树
     *                 if (predecessor.right == null) {
     *                     predecessor.right = root;
     *                     root = root.left;
     *                 }
     *                 // 说明左子树已经访问完了，我们需要断开链接
     *                 else {
     *                     res.add(root.val);
     *                     predecessor.right = null;
     *                     root = root.right;
     *                 }
     *             }
     *             // 如果没有左孩子，则直接访问右孩子
     *             else {
     *                 res.add(root.val);
     *                 root = root.right;
     *             }
     *         }
     *         return res;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉搜索树的节点个数。Morris 遍历中每个节点会被访问两次，因此总时间复杂度为 O(2n)=O(n)O(2n)=O(n)。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
