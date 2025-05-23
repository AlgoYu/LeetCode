package xiaoyu.algo.leetcode;

public class 重新排列字符串 {
    public String restoreString(String s, int[] indices) {
        char[] charArray = s.toCharArray();
        char[] res = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = charArray[i];
        }
        return new String(res);
    }
}
