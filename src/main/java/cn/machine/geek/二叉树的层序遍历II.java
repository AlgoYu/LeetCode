package cn.machine.geek;

import java.util.*;

/**
 * 二叉树的层序遍历 II
 * 难度
 * 中等
 * <p>
 * 416
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层序遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class 二叉树的层序遍历II {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }
    /**
     * 前言
     * 这道题和「102. 二叉树的层序遍历」相似，不同之处在于，第 102 题要求从上到下输出每一层的节点值，而这道题要求从下到上输出每一层的节点值。除了输出顺序不同以外，这两道题的思路是相同的，都可以使用广度优先搜索进行层次遍历。
     *
     * 方法一：广度优先搜索
     * 树的层次遍历可以使用广度优先搜索实现。从根节点开始搜索，每次遍历同一层的全部节点，使用一个列表存储该层的节点值。
     *
     * 如果要求从上到下输出每一层的节点值，做法是很直观的，在遍历完一层节点之后，将存储该层节点值的列表添加到结果列表的尾部。这道题要求从下到上输出每一层的节点值，只要对上述操作稍作修改即可：在遍历完一层节点之后，将存储该层节点值的列表添加到结果列表的头部。
     *
     * 为了降低在结果列表的头部添加一层节点值的列表的时间复杂度，结果列表可以使用链表的结构，在链表头部添加一层节点值的列表的时间复杂度是 O(1)O(1)。在 Java 中，由于我们需要返回的 List 是一个接口，这里可以使用链表实现；而 C++ 或 Python 中，我们需要返回一个 vector 或 list，它不方便在头部插入元素（会增加时间开销），所以我们可以先用尾部插入的方法得到从上到下的层次遍历列表，然后再进行反转。
     *
     * JavaC++Python3CGolang
     *
     * class Solution {
     *     public List<List<Integer>> levelOrderBottom(TreeNode root) {
     *         List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
     *         if (root == null) {
     *             return levelOrder;
     *         }
     *         Queue<TreeNode> queue = new LinkedList<TreeNode>();
     *         queue.offer(root);
     *         while (!queue.isEmpty()) {
     *             List<Integer> level = new ArrayList<Integer>();
     *             int size = queue.size();
     *             for (int i = 0; i < size; i++) {
     *                 TreeNode node = queue.poll();
     *                 level.add(node.val);
     *                 TreeNode left = node.left, right = node.right;
     *                 if (left != null) {
     *                     queue.offer(left);
     *                 }
     *                 if (right != null) {
     *                     queue.offer(right);
     *                 }
     *             }
     *             levelOrder.add(0, level);
     *         }
     *         return levelOrder;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉树中的节点个数。每个节点访问一次，结果列表使用链表的结构时，在结果列表头部添加一层节点值的列表的时间复杂度是 O(1)O(1)，因此总时间复杂度是 O(n)O(n)。
     *
     * 空间复杂度：O(n)O(n)，其中 nn 是二叉树中的节点个数。空间复杂度取决于队列开销，队列中的节点个数不会超过 nn。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/er-cha-shu-de-ceng-ci-bian-li-ii-by-leetcode-solut/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
