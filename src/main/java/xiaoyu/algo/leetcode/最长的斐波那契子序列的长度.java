package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 最长的斐波那契子序列的长度 {
    public static void main(String[] args) {
        最长的斐波那契子序列的长度 test = new 最长的斐波那契子序列的长度();
        test.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
    }


    // [1,2,3,4,5,6,7,8]
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int result = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                Integer index = indexMap.getOrDefault(arr[i] - arr[j], -1);
                if (index < 0) {
                    continue;
                }
                dp[j][i] = Math.max(dp[index][j] + 1, 3);
                result = Math.max(dp[j][i], result);
            }
        }
        return result;
    }
}
