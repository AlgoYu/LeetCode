package cn.machine.geek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 寻找图中是否存在路径 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        if (n > edges.length) {
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> targetA = map.computeIfAbsent(edge[0], k -> new ArrayList<>());
            List<Integer> targetB = map.computeIfAbsent(edge[1], k -> new ArrayList<>());
            targetA.add(edge[1]);
            targetB.add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        boolean[] already = new boolean[n];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            already[poll] = true;
            List<Integer> list = map.get(poll);
            if (list != null && !list.isEmpty()) {
                for (Integer target : list) {
                    if (already[target]) {
                        continue;
                    }
                    if (target == destination) {
                        return true;
                    }
                    queue.offer(target);
                }
            }
        }
        return false;
    }
}
