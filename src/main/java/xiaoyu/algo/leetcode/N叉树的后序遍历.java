package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
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
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 */
public class N叉树的后序遍历 {
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

    public List<Integer> postorder(Node root) {
        return postorder(new ArrayList<>(), root);
    }

    private List<Integer> postorder(List<Integer> list, Node root) {
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            postorder(list, node);
        }
        list.add(root.val);
        return list;
    }
    /**
     * 方法：递归
     * 由于递归实现 N 叉树的后序遍历较为简单，因此我们只讲解如何使用迭代的方法得到 N 叉树的后序遍历。
     *
     * 在后序遍历中，我们会先遍历一个节点的所有子节点，再遍历这个节点本身。
     *
     * 例如：当前的节点为 u，它的子节点为 v1, v2, v3 时，那么后序遍历的结果为
     *
     *
     * [children of v1], v1, [children of v2], v2, [children of v3], v3, u
     * 其中 [children of vk] 表示以 vk 为根节点的子树的后序遍历结果（不包括 vk）。
     *
     * 将结果反转，得到
     *
     *
     * u, v3, [children of v3]', v2, [children of v2]', v1, [children of v1]'
     * 其中 [a]' 表示 [a] 的反转。
     *
     * 此时我们发现，结果和前序遍历非常类似，只不过前序遍历中对子节点的遍历顺序是 v1, v2, v3，而这里是 v3, v2, v1。
     *
     * 因此我们可以使用和 N叉树的前序遍历 相同的方法，使用一个栈来得到后序遍历。我们首先把根节点入栈。
     *
     * 算法
     *
     * 当每次我们从栈顶取出一个节点 u 时，就把 u 的所有子节点顺序推入栈中。例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v1, v2, v3，这样就保证了下一个遍历到的节点（即 u 的第一个子节点 v3）出现在栈顶的位置。在遍历结束之后，我们把遍历结果反转，就可以得到后序遍历。
     *
     * JavaPython
     *
     * class Solution {
     *     public List<Integer> postorder(Node root) {
     *         LinkedList<Integer> res = new LinkedList<>();
     *         if (root == null) {
     *             return res;
     *         }
     *
     *         Deque<Node> stack = new ArrayDeque<>();
     *         stack.addLast(root);
     *         while (!stack.isEmpty()) {
     *             Node node = stack.removeLast();
     *             res.addFirst(node.val);
     *             for (int i = 0; i < node.children.size(); i++) {
     *                 stack.addLast(node.children.get(i));
     *             }
     *         }
     *         return res;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：时间复杂度：O(M)O(M)，其中 MM 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。
     *
     * 空间复杂度：O(M)O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。将根节点推出栈后，需要将这些节点都放入栈，共有 M - 1M−1 个节点，因此栈的大小为 O(M)O(M)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/ncha-shu-de-hou-xu-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
