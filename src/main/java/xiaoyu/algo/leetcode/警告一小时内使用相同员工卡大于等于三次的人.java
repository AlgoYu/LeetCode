package xiaoyu.algo.leetcode;

import java.util.*;

public class 警告一小时内使用相同员工卡大于等于三次的人 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> times = map.computeIfAbsent(keyName[i], k -> new ArrayList<>());
            times.add(parseMinutes(keyTime[i]));
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            value.sort(((o1, o2) -> o1 - o2));
            if (conditionTrue(value)) {
                names.add(entry.getKey());
            }
        }
        names.sort(String::compareTo);
        return names;
    }

    private boolean conditionTrue(List<Integer> times) {
        int n = times.size();
        if (n < 3) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (times.get(i) - times.get(i - 2) <= 60) {
                return true;
            }
        }
        return false;
    }

    private int parseMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
