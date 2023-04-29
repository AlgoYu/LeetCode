package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/14 12:35 下午
 * @Email 794763733@qq.com
 */
public class 山峰数组的顶部 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (mid == 0 || arr[mid] >= arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
