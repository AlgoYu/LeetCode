package xiaoyu.algo.leetcode;

import java.util.*;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/6 4:47 下午
 * @Email 794763733@qq.com
 */
public class 旅行终点站 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> list = paths.get(i);
            for (int j = 0; j < list.size(); j++) {
                String s = list.get(j);
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (j == list.size() - 1) {
                    set.add(s);
                }
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if (!set.contains(next.getKey())) {
                continue;
            }
            if (next.getValue() == 1) {
                return next.getKey();
            }
        }
        return "";
    }
}
