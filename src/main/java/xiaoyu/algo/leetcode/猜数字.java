package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 6:41 下午
 * @Email 794763733@qq.com
 */
public class 猜数字 {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
