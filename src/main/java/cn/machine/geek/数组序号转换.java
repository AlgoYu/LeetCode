package cn.machine.geek;

import java.util.*;

public class 数组序号转换 {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortArr);
        int index = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortArr.length; i++) {
            if (i > 0 && sortArr[i] == sortArr[i - 1]) {
                continue;
            }
            map.put(sortArr[i], index++);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
