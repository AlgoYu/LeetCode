package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 5:40 下午
 * @Email 794763733@qq.com
 */
public class 将有序数组转换为二叉搜索树 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid - 1);
        node.right = dfs(nums, mid + 1, right);
        return node;
    }
}
