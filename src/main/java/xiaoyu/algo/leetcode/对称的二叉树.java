package xiaoyu.algo.leetcode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 */
public class 对称的二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || func(root.left, root.right);
    }

    public boolean func(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return func(left.left, right.right) && func(left.right, right.left);
    }

    /**
     * 解题思路：
     * 对称二叉树定义： 对于树中 任意两个对称节点 LL 和 RR ，一定有：
     * L.val = R.valL.val=R.val ：即此两对称节点值相等。
     * L.left.val = R.right.valL.left.val=R.right.val ：即 LL 的 左子节点 和 RR 的 右子节点 对称；
     * L.right.val = R.left.valL.right.val=R.left.val ：即 LL 的 右子节点 和 RR 的 左子节点 对称。
     * 根据以上规律，考虑从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树。
     *
     *
     * 算法流程：
     * isSymmetric(root) ：
     *
     * 特例处理： 若根节点 root 为空，则直接返回 truetrue 。
     * 返回值： 即 recur(root.left, root.right) ;
     * recur(L, R) ：
     *
     * 终止条件：
     * 当 LL 和 RR 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 truetrue ；
     * 当 LL 或 RR 中只有一个越过叶节点： 此树不对称，因此返回 falsefalse ；
     * 当节点 LL 值 \ne
     * 
     * ​
     *  = 节点 RR 值： 此树不对称，因此返回 falsefalse ；
     * 递推工作：
     * 判断两节点 L.leftL.left 和 R.rightR.right 是否对称，即 recur(L.left, R.right) ；
     * 判断两节点 L.rightL.right 和 R.leftR.left 是否对称，即 recur(L.right, R.left) ；
     * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
     *
     * 1 / 10
     *
     * 复杂度分析：
     *
     * 时间复杂度 O(N)O(N) ： 其中 NN 为二叉树的节点数量，每次执行 recur() 可以判断一对节点是否对称，因此最多调用 N/2N/2 次 recur() 方法。
     * 空间复杂度 O(N)O(N) ： 最差情况下（见下图），二叉树退化为链表，系统使用 O(N)O(N) 大小的栈空间。
     *
     *
     *
     *
     * pythonjava
     *
     * class Solution {
     *     public boolean isSymmetric(TreeNode root) {
     *         return root == null ? true : recur(root.left, root.right);
     *     }
     *     boolean recur(TreeNode L, TreeNode R) {
     *         if(L == null && R == null) return true;
     *         if(L == null || R == null || L.val != R.val) return false;
     *         return recur(L.left, R.right) && recur(L.right, R.left);
     *     }
     * }
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
