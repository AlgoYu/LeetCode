package xiaoyu.algo.leetcode;

public class 可被三整除的偶数的平均值 {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
