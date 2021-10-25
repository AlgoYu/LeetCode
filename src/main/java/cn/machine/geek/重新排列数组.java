package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 7:20 下午
 * @Email 794763733@qq.com
 */
public class 重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;
        int tail = n;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                result[i] = nums[index++];
            } else {
                result[i] = nums[tail++];
            }
            flag = !flag;
        }
        return result;
    }
}
