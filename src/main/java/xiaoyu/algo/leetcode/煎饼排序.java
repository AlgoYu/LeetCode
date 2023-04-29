package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class 煎饼排序 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new LinkedList<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[n - 1] == n) {
                n--;
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (arr[j] == n) {
                    reverse(arr, j);
                    reverse(arr, i);
                    result.add(j + 1);
                    result.add(i + 1);
                    n--;
                    break;
                }
            }
        }
        return result;
    }

    private void reverse(int[] arr, int k) {
        int l = 0;
        while (l < k) {
            int temp = arr[l];
            arr[l++] = arr[k];
            arr[k--] = temp;
        }
    }
}
