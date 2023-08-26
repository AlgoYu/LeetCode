package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir, Map<Integer, Integer> map) {
        if (pl > pr || il > ir) {
            return null;
        }
        Integer rootIndex = map.get(preorder[pl]);
        TreeNode node = new TreeNode(inorder[rootIndex]);
        int leftLength = rootIndex - il;
        node.left = buildTree(preorder, inorder, pl + 1, pl + leftLength, il, rootIndex - 1, map);
        node.right = buildTree(preorder, inorder, pl + leftLength + 1, pr, rootIndex + 1, ir, map);
        return node;
    }
}
