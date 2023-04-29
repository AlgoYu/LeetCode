package xiaoyu.algo.leetcode;

public class 最长特殊序列Ⅰ {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
