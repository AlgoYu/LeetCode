package xiaoyu.algo.leetcode;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int index = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                n++;
            } else {
                nums[index++] = nums[i];
            }
        }
        return nums.length - n;
    }
}
