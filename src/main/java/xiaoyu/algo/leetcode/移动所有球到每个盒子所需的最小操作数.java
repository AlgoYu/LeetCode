package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 移动所有球到每个盒子所需的最小操作数 {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        List<Integer> boll = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) != '0') {
                boll.add(i);
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (Integer b : boll) {
                if (b == i) {
                    continue;
                }
                answer[i] = answer[i] + (Math.abs(i - b));
            }
        }
        return answer;
    }
}