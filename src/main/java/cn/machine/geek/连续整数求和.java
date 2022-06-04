package cn.machine.geek;

public class 连续整数求和 {
    public int consecutiveNumbersSum(int n) {
        int total = 1;
        for (int i = 1; i <= n; i++) {
            int count = i;
            for (int j = i + 1; j <= n; j++) {
                count += j;
                if (count >= n) {
                    if (count == n) {
                        total++;
                    }
                    break;
                }
            }
        }
        return total;
    }
}
