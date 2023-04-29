package xiaoyu.algo.leetcode;

import java.util.Arrays;

public class 字符的最短距离 {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int[] answer = new int[chars.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != c) {
                continue;
            }
            answer[i] = 0;
            int left = i - 1;
            int right = i + 1;
            while ((left >= 0 && answer[left] > i - left) || (right < answer.length && answer[right] > right - i)) {
                if (left >= 0 && answer[left] > i - left) {
                    answer[left] = Math.min(answer[left], i - left);
                    left--;
                }
                if (right < answer.length && answer[right] > right - i) {
                    answer[right] = right - i;
                    right++;
                }
            }
        }
        return answer;
    }
}
