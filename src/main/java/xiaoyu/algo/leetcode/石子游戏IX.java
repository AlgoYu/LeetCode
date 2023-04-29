package xiaoyu.algo.leetcode;

public class 石子游戏IX {

    public boolean stoneGameIX(int[] stones) {
        int type1 = 0, type2 = 0, type3 = 0;
        for (int stone : stones) {
            int n = stone % 3;
            switch (n) {
                case 0:
                    type1++;
                    break;
                case 1:
                    type2++;
                    break;
                case 2:
                    type3++;
                    break;
            }
        }
        if (type1 % 2 == 0) {
            return type2 >= 1 && type3 >= 1;
        }
        return Math.abs(type2 - type3) > 2;
    }
}
