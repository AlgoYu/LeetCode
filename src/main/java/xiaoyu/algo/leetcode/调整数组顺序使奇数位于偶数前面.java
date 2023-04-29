package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/21 2:03 下午
 * @Email 794763733@qq.com
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right && (nums[left] & 1) == 1) {
                left++;
            }
            while (right >= left && (nums[right] & 1) == 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
