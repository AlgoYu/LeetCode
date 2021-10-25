package cn.machine.geek;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 6:42 下午
 * @Email 794763733@qq.com
 */
public class 宝石与石头 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int n = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                n++;
            }
        }
        return n;
    }
}
