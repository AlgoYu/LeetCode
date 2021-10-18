package cn.machine.geek;

import java.util.Arrays;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/18 11:08 下午
 * @Email 794763733@qq.com
 */
public class 早餐组合 {
    private static final int mod = (int) (1e9 + 7);

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int n = 0;
        Arrays.sort(drinks);
        for (int i = 0; i < staple.length; i++) {
            if (staple[i] > x) {
                continue;
            }
            n += findBounds(drinks, x - staple[i]);
            n %= mod;
        }
        return n;
    }

    private int findBounds(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (array[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
