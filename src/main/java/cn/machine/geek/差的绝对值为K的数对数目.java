package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/30 4:52 下午
 * @Email 794763733@qq.com
 */
public class 差的绝对值为K的数对数目 {
    public int countKDifference(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    total++;
                }
            }
        }
        return total;
    }
}
