package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/14 12:52 下午
 * @Email 794763733@qq.com
 */
public class 山脉数组的峰顶索引 {
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
