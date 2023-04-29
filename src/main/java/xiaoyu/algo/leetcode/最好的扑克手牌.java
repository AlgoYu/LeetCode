package xiaoyu.algo.leetcode;

public class 最好的扑克手牌 {
    public String bestHand(int[] ranks, char[] suits) {
        boolean three = false;
        boolean pair = false;
        int[] rankCount = new int[13];
        int[] suitCount = new int[4];
        for (int i = 0; i < ranks.length; i++) {
            rankCount[ranks[i] - 1]++;
            suitCount[suits[i] - 'a']++;

            if (suitCount[suits[i] - 'a'] >= 5) {
                return "Flush";
            }

            if (rankCount[ranks[i] - 1] >= 3) {
                three = true;
            }

            if (rankCount[ranks[i] - 1] >= 2) {
                pair = true;
            }
        }

        return three ? "Three of a Kind" : pair ? "Pair" : "High Card";
    }
}
