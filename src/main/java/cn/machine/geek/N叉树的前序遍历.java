package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 */
public class N叉树的前序遍历 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        return preorder(new ArrayList<>(), root);
    }

    private List<Integer> preorder(List<Integer> list, Node node) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        if (node.children == null || node.children.size() == 0) {
            return list;
        }
        for (Node n : node.children) {
            preorder(list, n);
        }
        return list;
    }
    /**
     * 方法：迭代
     * 由于递归实现 N 叉树的前序遍历较为简单，因此我们只讲解如何使用迭代的方法得到 N 叉树的前序遍历。
     *
     * 我们使用栈来帮助我们得到前序遍历，需要保证栈顶的节点就是我们当前遍历到的节点。
     *
     * 我们首先把根节点入栈，因为根节点是前序遍历中的第一个节点。随后每次我们从栈顶取出一个节点 u，它是我们当前遍历到的节点，并把 u 的所有子节点逆序推入栈中。例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v3, v2, v1，这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v1）出现在栈顶的位置。
     *
     * JavaPython
     *
     * class Solution {
     *     public List<Integer> preorder(Node root) {
     *         LinkedList<Integer> output = new LinkedList<>();
     *         if (root == null) {
     *             return output;
     *         }
     *
     *         LinkedList<Node> stack = new LinkedList<>();
     *         stack.add(root);
     *         while (!stack.isEmpty()) {
     *             Node node = stack.pollLast();
     *             output.add(node.val);
     *             Collections.reverse(node.children);
     *             for (Node item : node.children) {
     *                 stack.add(item);
     *             }
     *         }
     *         return output;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：时间复杂度：O(M)O(M)，其中 MM 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。
     *
     * 空间复杂度：O(M)O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1M−1 个节点，因此栈的大小为 O(M)O(M)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/ncha-shu-de-qian-xu-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
