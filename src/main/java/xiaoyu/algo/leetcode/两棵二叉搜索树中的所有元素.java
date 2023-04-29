package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class 两棵二叉搜索树中的所有元素 {

    public static class TreeNode {
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

    public static void main(String[] args) {
        两棵二叉搜索树中的所有元素 test = new 两棵二叉搜索树中的所有元素();
        TreeNode no1 = new TreeNode(1);
        no1.left = new TreeNode(0);
        no1.right = new TreeNode(3);
        TreeNode no2 = new TreeNode(1);
        no1.left = new TreeNode(0);
        no1.right = new TreeNode(3);
        List<Integer> result = new LinkedList<>();
        test.getAllElements(no1, no2);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> orderTree1 = new LinkedList<>();
        List<Integer> orderTree2 = new LinkedList<>();
        dfs(root1, orderTree1);
        dfs(root2, orderTree2);
        if (orderTree1.size() == 0 || orderTree2.size() == 0) {
            return orderTree1.size() == 0 ? orderTree2 : orderTree1;
        }
        List<Integer> result = new ArrayList<>(orderTree1.size() + orderTree2.size());
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == orderTree1.size()) {
                result.addAll(orderTree2.subList(index2, orderTree2.size()));
                return result;
            }
            if (index2 == orderTree2.size()) {
                result.addAll(orderTree1.subList(index1, orderTree1.size()));
                return result;
            }
            int num1 = index1 < orderTree1.size() ? orderTree1.get(index1) : Integer.MIN_VALUE;
            int num2 = index2 < orderTree2.size() ? orderTree2.get(index2) : Integer.MIN_VALUE;
            if (num1 <= num2) {
                result.add(num1);
                index1++;
            } else {
                result.add(num2);
                index2++;
            }
        }
    }

    private void dfs(TreeNode treeNode, List<Integer> orderTree) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, orderTree);
        }
        orderTree.add(treeNode.val);
        if (treeNode.right != null) {
            dfs(treeNode.right, orderTree);
        }
    }
}