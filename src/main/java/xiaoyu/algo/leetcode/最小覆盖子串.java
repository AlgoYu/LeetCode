package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/4 3:30 下午
 * @Email 794763733@qq.com
 */
public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return "";
        }
        Map<Character, Integer> count = getMap(t);
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        String result = "";
        int min = Integer.MAX_VALUE;
        while (right < n) {
            char c = s.charAt(right);
            if (count.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            while (compare(count, map) && left <= right) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            right++;
        }
        return result;
    }

    private boolean compare(Map<Character, Integer> count, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            Integer num = map.getOrDefault(entry.getKey(), 0);
            if (num < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            result.put(str.charAt(i), result.getOrDefault(str.charAt(i), 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        最小覆盖子串 test = new 最小覆盖子串();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
    }
}
