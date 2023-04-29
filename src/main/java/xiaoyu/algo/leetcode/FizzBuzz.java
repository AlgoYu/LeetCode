package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/13 3:04 下午
 * @Email 794763733@qq.com
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean three = i % 3 == 0;
            boolean five = i % 5 == 0;
            if (three && five) {
                list.add("FizzBuzz");
                continue;
            }
            if (three) {
                list.add("Fizz");
                continue;
            }
            if (five) {
                list.add("Buzz");
                continue;
            }
            list.add(String.valueOf(i));
        }
        return list;
    }
}
