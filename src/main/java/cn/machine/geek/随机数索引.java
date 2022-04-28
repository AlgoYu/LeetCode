package cn.machine.geek;

import java.util.*;

public class 随机数索引 {
    Map<Integer, List<Integer>> map;

    public 随机数索引(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.computeIfAbsent(nums[i], k -> new LinkedList<>());
            list.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int index = (int) Math.floor(Math.random() * list.size());
        return list.get(index);
    }
}
