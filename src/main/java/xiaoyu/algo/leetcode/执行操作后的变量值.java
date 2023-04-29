package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 7:15 下午
 * @Email 794763733@qq.com
 */
public class 执行操作后的变量值 {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String str : operations) {
            if (str.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
