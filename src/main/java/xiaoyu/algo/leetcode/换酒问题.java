package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/12 4:27 下午
 * @Email 794763733@qq.com
 */
public class 换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        int count = numBottles;
        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            count += newBottles;
            empty = empty - (newBottles * numExchange) + newBottles;
        }
        return count;
    }
}
