package cn.machine.geek;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/29 5:43 下午
 * @Email 794763733@qq.com
 */
public class 拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
