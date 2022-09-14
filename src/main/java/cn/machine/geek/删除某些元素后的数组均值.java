package cn.machine.geek;

import java.util.Arrays;

public class 删除某些元素后的数组均值 {
    public double trimMean(int[] arr) {
        double result = 0D;
        int n = arr.length;
        int l = (int) (n * 0.05F);
        Arrays.sort(arr);
        for (int i = l; i < n - l; i++) {
            result += arr[i];
        }
        return result / (n - 2 * l);
    }
}
