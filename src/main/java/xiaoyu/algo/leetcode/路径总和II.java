package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 路径总和II {
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

    List<List<Integer>> result = new LinkedList<>();
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        traverse(root, 0, new ArrayList<>());
        return result;
    }

    private void traverse(TreeNode root, int cur, List<Integer> path) {
        if (root == null) {
            return;
        }
        cur += root.val;
        path.add(root.val);
        if (cur == targetSum && root.left == null && root.right == null) {
            List<Integer> tempResult = new LinkedList<>(path);
            result.add(tempResult);
        } else {
            traverse(root.left, cur, path);
            traverse(root.right, cur, path);
        }
        path.remove(path.size() - 1);
    }
}
