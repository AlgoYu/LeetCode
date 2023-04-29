package xiaoyu.algo.leetcode;

public class 气球的最大数量 {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            switch (ch) {
                case 'b':
                    count[0]++;
                    break;
                case 'a':
                    count[1]++;
                    break;
                case 'l':
                    count[2]++;
                    break;
                case 'o':
                    count[3]++;
                    break;
                case 'n':
                    count[4]++;
                    break;
            }
        }
        int total = 0;
        X:
        for (; ; ) {
            count[0]--;
            count[1]--;
            count[2] -= 2;
            count[3] -= 2;
            count[4]--;
            for (int i = 0; i < count.length; i++) {
                if (count[i] < 0) {
                    break X;
                }
            }
            total++;
        }
        return total;
    }
}
