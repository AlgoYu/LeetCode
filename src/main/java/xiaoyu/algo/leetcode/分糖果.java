package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/29 4:36 下午
 * @Email 794763733@qq.com
 */
public class 分糖果 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
