package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/15 10:39 上午
 * @Email 794763733@qq.com
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (compare(nums, mid, mid - 1) > 0 && compare(nums, mid, mid + 1) > 0) {
                return mid;
            }
            if (compare(nums, mid, mid - 1) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

    private int compare(int[] nums, int current, int index) {
        if (index < 0 || index >= nums.length) {
            return 1;
        }
        return nums[current] - nums[index];
    }
}
