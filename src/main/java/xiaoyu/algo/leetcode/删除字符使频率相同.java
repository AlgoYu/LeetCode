package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 删除字符使频率相同 {
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            count[i]--;
            for (int num : count) {
                if (num > 0) {
                    set.add(num);
                }
            }
            if (set.size() == 1) {
                return true;
            }
            set.clear();
            count[i]++;
        }
        return false;
    }
}
