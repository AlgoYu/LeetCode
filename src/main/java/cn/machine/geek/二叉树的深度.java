package cn.machine.geek;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 */
public class 二叉树的深度 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        int height = 0;
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int layer = queue.size();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                layer--;
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
                if(layer==0){
                    height++;
                    layer = queue.size();
                }
            }
        }
        return height;
    }
    /**
     * 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；
     *
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历；
     * 常见的 BFS ： 层序遍历（即按层遍历）。
     * 求树的深度需要遍历树的所有节点，本文将介绍基于 后序遍历（DFS） 和 层序遍历（BFS） 的两种解法。
     * 方法一：后序遍历（DFS）
     * 树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。
     * 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。
     *
     *
     * 算法解析：
     * 终止条件： 当 root​ 为空，说明已越过叶节点，因此返回 深度 00 。
     * 递推工作： 本质上是对树做后序遍历。
     * 计算节点 root​ 的 左子树的深度 ，即调用 maxDepth(root.left)；
     * 计算节点 root​ 的 右子树的深度 ，即调用 maxDepth(root.right)；
     * 返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。
     *
     * 1 / 10
     *
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： NN 为树的节点数量，计算树的深度需要遍历所有节点。
     * 空间复杂度 O(N)O(N) ： 最差情况下（当树退化为链表时），递归深度可达到 NN 。
     * pythonjava
     *
     * class Solution {
     *     public int maxDepth(TreeNode root) {
     *         if(root == null) return 0;
     *         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
     *     }
     * }
     * 方法二：层序遍历（BFS）
     * 树的层序遍历 / 广度优先搜索往往利用 队列 实现。
     * 关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
     * 算法解析：
     * 特例处理： 当 root​ 为空，直接返回 深度 00 。
     * 初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
     * 循环遍历： 当 queue 为空时跳出。
     * 初始化一个空列表 tmp ，用于临时存储下一层节点；
     * 遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
     * 更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
     * 统计层数： 执行 res += 1 ，代表层数加 11；
     * 返回值： 返回 res 即可。
     *
     * 1 / 6
     *
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： NN 为树的节点数量，计算树的深度需要遍历所有节点。
     * 空间复杂度 O(N)O(N) ： 最差情况下（当树平衡时），队列 queue 同时存储 N/2N/2 个节点。
     * pythonjava
     *
     * class Solution {
     *     public int maxDepth(TreeNode root) {
     *         if(root == null) return 0;
     *         List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
     *         int res = 0;
     *         while(!queue.isEmpty()) {
     *             tmp = new LinkedList<>();
     *             for(TreeNode node : queue) {
     *                 if(node.left != null) tmp.add(node.left);
     *                 if(node.right != null) tmp.add(node.right);
     *             }
     *             queue = tmp;
     *             res++;
     *         }
     *         return res;
     *     }
     * }
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
