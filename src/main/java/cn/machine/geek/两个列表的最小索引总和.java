package cn.machine.geek;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 两个列表的最小索引总和 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index == null) {
                continue;
            }
            int num = index + i;
            if (num == min) {
                result.add(list2[i]);
            }
            if (num < min) {
                min = num;
                result.clear();
                result.add(list2[i]);
            }
        }
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
