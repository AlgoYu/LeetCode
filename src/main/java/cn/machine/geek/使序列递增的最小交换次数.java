package cn.machine.geek;

public class 使序列递增的最小交换次数 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // a为不换，b为换。
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int preA = a, preB = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, preA);
                b = Math.min(b, preB + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, preB);
                b = Math.min(b, preA + 1);
            }
        }
        return Math.min(a, b);
    }
}
