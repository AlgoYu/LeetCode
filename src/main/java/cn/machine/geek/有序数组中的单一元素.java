package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/10 1:46 下午
 * @Email 794763733@qq.com
 */
public class 有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
}
