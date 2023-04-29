package xiaoyu.algo.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉搜索树迭代器 {
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

    List<TreeNode> list;
    int index;

    public 二叉搜索树迭代器(TreeNode root) {
        list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur);
                cur = cur.right;
            }
        }
        index = 0;
    }

    public int next() {
        return list.get(index++).val;
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
