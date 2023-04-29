package xiaoyu.algo.leetcode;

public class 构造字典序最大的合并字符串 {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        StringBuilder result = new StringBuilder();
        while (sb1.length() > 0 || sb2.length() > 0) {
            if (sb1.length() == 0 || sb2.length() == 0) {
                result.append(sb1.length() == 0 ? sb2 : sb1);
                return result.toString();
            }
            /*if (sb1.compareTo(sb2) > 0) {
                result.append(sb1.charAt(0));
                sb1.delete(0, 1);
            } else {
                result.append(sb2.charAt(0));
                sb2.delete(0, 1);
            }*/
        }
        return result.toString();
    }
}
