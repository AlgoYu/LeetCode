package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 打家劫舍III {

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

    Map<String, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return Math.max(dfs(root, true), dfs(root, false));
    }

    public int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        Integer childrenValue = map.get(root.hashCode() + "" + flag);
        if (childrenValue == null) {
            childrenValue = Math.max(dfs(root.left, !flag), dfs(root.left, false)) + Math.max(dfs(root.right, !flag), dfs(root.right, false));
            map.put(root.hashCode() + "" + flag, childrenValue);
        }
        return flag ? childrenValue + root.val : childrenValue;
    }
}
