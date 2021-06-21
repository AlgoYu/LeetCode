package cn.machine.geek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class 从上到下打印二叉树 {
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

    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new int[0];
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 解题思路：
     * 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
     * BFS 通常借助 队列 的先入先出特性来实现。
     *
     *
     * 算法流程：
     * 特例处理： 当树的根节点为空，则直接返回空列表 [] ；
     * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
     * BFS 循环： 当队列 queue 为空时跳出；
     * 出队： 队首元素出队，记为 node；
     * 打印： 将 node.val 添加至列表 tmp 尾部；
     * 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
     * 返回值： 返回打印结果列表 res 即可。
     *
     * 1 / 17
     *
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： NN 为二叉树的节点数量，即 BFS 需循环 NN 次。
     * 空间复杂度 O(N)O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2N/2 个树节点同时在 queue 中，使用 O(N)O(N) 大小的额外空间。
     * 代码：
     * Python 中使用 collections 中的双端队列 deque() ，其 popleft() 方法可达到 O(1)O(1) 时间复杂度；列表 list 的 pop(0) 方法时间复杂度为 O(N)O(N) 。
     *
     * pythonjava
     *
     * class Solution {
     *     public int[] levelOrder(TreeNode root) {
     *         if(root == null) return new int[0];
     *         Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
     *         ArrayList<Integer> ans = new ArrayList<>();
     *         while(!queue.isEmpty()) {
     *             TreeNode node = queue.poll();
     *             ans.add(node.val);
     *             if(node.left != null) queue.add(node.left);
     *             if(node.right != null) queue.add(node.right);
     *         }
     *         int[] res = new int[ans.size()];
     *         for(int i = 0; i < ans.size(); i++)
     *             res[i] = ans.get(i);
     *         return res;
     *     }
     * }
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/mian-shi-ti-32-i-cong-shang-dao-xia-da-yin-er-ch-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
