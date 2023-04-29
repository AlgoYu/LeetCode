package xiaoyu.algo.leetcode;

public class 区域和检索数组可修改 {
    int[] segmentTree;
    int n;

    public 区域和检索数组可修改(int[] nums) {
        n = nums.length;
        segmentTree = new int[n * 4];
        build(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        change(0, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return range(0, 0, n - 1, left, right);
    }

    private void build(int node, int left, int right, int[] nums) {
        // 叶子节点
        if (left == right) {
            segmentTree[node] = nums[left];
            return;
        }
        // 中间节点
        int mid = left + ((right - left) >> 1);
        // 构建左子树
        build(node * 2 + 1, left, mid, nums);
        // 构建右子树
        build(node * 2 + 2, mid + 1, right, nums);
        // 当前节点的值
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private void change(int node, int left, int right, int index, int val) {
        if (left == right) {
            segmentTree[node] = val;
            return;
        }
        // 中间节点
        int mid = left + ((right - left) >> 1);
        // 修改值在左边，进入左子树。
        if (index <= mid) {
            change(node * 2 + 1, left, mid, index, val);
        } else {
            // 修改值在右边，进入右子树
            change(node * 2 + 2, mid + 1, right, index, val);
        }
        // 更新当前节点的值
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private int range(int node, int left, int right, int searchLeft, int searchRight) {
        // 找到区间和
        if (left == searchLeft && right == searchRight) {
            return segmentTree[node];
        }
        // 中间节点
        int mid = left + ((right - left) >> 1);
        // 搜索的是左边区间，进入左子树
        if (searchRight <= mid) {
            return range(node * 2 + 1, left, mid, searchLeft, searchRight);
        } else if (searchLeft > mid) {
            // 搜素的是右边区间，进入右子树
            return range(node * 2 + 2, mid + 1, right, searchLeft, searchRight);
        } else {
            return range(node * 2 + 1, left, mid, searchLeft, mid) + range(node * 2 + 2, mid + 1, right, mid + 1, searchRight);
        }
    }

    public static void main(String[] args) {
        区域和检索数组可修改 test = new 区域和检索数组可修改(new int[]{1, 4, 2, 3, 4});
        System.out.println(test.sumRange(0, 0));
        System.out.println(test.sumRange(0, 3));
        System.out.println(test.sumRange(0, 4));
        System.out.println(test.sumRange(3, 4));
        test.update(1, 10);
        test.update(0, -10);
        System.out.println(test.sumRange(0, 1));
    }
}
