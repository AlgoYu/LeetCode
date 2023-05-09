package xiaoyu.algo.leetcode;

class 有效时间的数目 {
    public int countTime(String time) {
        int countH = 0;
        for (int i = 0; i < 24; i++) {
            int h1 = i / 10;
            int h2 = i % 10;
            if ((time.charAt(0) == '?' || time.charAt(0) == '0' + h1) && (time.charAt(1) == '?' || time.charAt(1) == '0' + h2)) {
                countH++;
            }
        }
        int countM = 0;
        for (int i = 0; i < 60; i++) {
            int m1 = i / 10;
            int m2 = i % 10;
            if ((time.charAt(3) == '?' || time.charAt(3) == '0' + m1) && (time.charAt(4) == '?' || time.charAt(4) == '0' + m2)) {
                countM++;
            }
        }
        return countH * countM;
    }
}