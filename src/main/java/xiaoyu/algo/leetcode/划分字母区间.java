package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/2 8:39 下午
 * @Email 794763733@qq.com
 */
public class 划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int index = 0;
        while (index < n) {
            char c = s.charAt(index);
            int max = s.lastIndexOf(c);
            if (index == max) {
                result.add(1);
                index++;
                continue;
            }
            int temp = index + 1;
            while (temp < max) {
                int i = s.lastIndexOf(s.charAt(temp));
                max = Math.max(max, i);
                temp++;
            }
            result.add(max - index + 1);
            index = max + 1;
        }
        return result;
    }
}
