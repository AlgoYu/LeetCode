package xiaoyu.algo.leetcode;

public class 排序数组 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arrays, left, right);
            quickSort(arrays, left, pivotIndex - 1);
            quickSort(arrays, pivotIndex + 1, right);
        }
    }

    private int partition(int[] arrays, int left, int right) {
        int mid = left + (right - left) / 2;
        int p = arrays[mid];
        swap(arrays, mid, right);
        int lowIndex = left;
        for (int i = left; i < right; i++) {
            if (arrays[i] < p) {
                swap(arrays, i, lowIndex++);
            }
        }
        swap(arrays, lowIndex, right);
        return lowIndex;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
