package xiaoyu.algo.leetcode;

public class UTF8编码验证 {
    private static final int MASK1 = 1 << 7;
    private static final int MASK2 = (1 << 7) + (1 << 6);

    public boolean validUtf8(int[] data) {
        int index = 0;
        int n = data.length;
        while (index < n) {
            int num = numBits(data[index]);
            if (num <= 0 || index + (num - 1) >= n) {
                return false;
            }
            for (int i = 1; i < num; i++) {
                if (!validByte(data[index + i])) {
                    return false;
                }
            }
            index += num;
        }
        return true;
    }

    private int numBits(int num) {
        if ((num & MASK1) == 0) {
            return 1;
        }
        int n = 0;
        int mask = MASK1;
        for (int i = 0; i < 5; i++) {
            if ((mask & num) != mask) {
                break;
            }
            n++;
            mask >>= 1;
        }
        return n == 1 ? 0 : n > 4 ? -1 : n;
    }

    private boolean validByte(int num) {
        return (num & MASK2) == MASK1;
    }
}
