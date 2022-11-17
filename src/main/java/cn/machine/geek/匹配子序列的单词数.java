package cn.machine.geek;

import javax.management.Query;
import java.util.*;

public class 匹配子序列的单词数 {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] map = new Queue[26];
        for (int i = 0; i < words.length; i++) {
            int index = words[i].charAt(0) - 'a';
            if (map[index] == null) {
                map[index] = new LinkedList<>();
            }
            // <记录在words里的下标,记录目前匹配到的下标>
            map[index].offer(new int[]{i, 0});
        }
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Queue<int[]> queue = map[c - 'a'];
            if (queue == null) {
                continue;
            }
            // 这里只能循环一次，避免连续相同的字符反复塞到一个队列里被一次匹配。
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] poll = queue.poll();
                poll[1]++;
                if (poll[1] == words[poll[0]].length()) {
                    total++;
                } else {
                    int nextIndex = words[poll[0]].charAt(poll[1]) - 'a';
                    if (map[nextIndex] == null) {
                        map[nextIndex] = new LinkedList<>();
                    }
                    map[nextIndex].offer(poll);
                }
            }
        }
        return total;
    }
}