package xiaoyu.algo.leetcode;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean way = true;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    tempList.add(way ? tempList.size() : 0, curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            way = !way;
            if (!tempList.isEmpty()) {
                result.add(tempList);
            }
        }
        return result;
    }


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

}
