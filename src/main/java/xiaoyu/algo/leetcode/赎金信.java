package xiaoyu.algo.leetcode;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countRansom = new int[26];
        int[] countMagazine = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            countRansom[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            countMagazine[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < countRansom.length; i++) {
            if (countRansom[i] > 0 && countRansom[i] < countMagazine[i]) {
                return false;
            }
        }
        return true;
    }
}
