package xiaoyu.algo.leetcode;

public class 优美的排列II {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            answer[index++] = i;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            answer[index++] = i;
            if (i != j) {
                answer[index++] = j;
            }
        }
        return answer;
    }
}
