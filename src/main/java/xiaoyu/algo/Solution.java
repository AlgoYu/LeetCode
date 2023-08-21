package xiaoyu.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                char temp = ch;
                if (temp >= 'A' && temp <= 'Z') {
                    temp = (char) ('a' + (temp - 'A'));
                }
                sb.append(temp);
            }
        }
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}