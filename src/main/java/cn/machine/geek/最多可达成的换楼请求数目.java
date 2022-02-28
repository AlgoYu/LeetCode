package cn.machine.geek;

public class 最多可达成的换楼请求数目 {
    public int maximumRequests(int n, int[][] requests) {
        int[] buildings = new int[n];
        return backtrack(buildings, requests, 0, 0);
    }

    private int backtrack(int[] buildings, int[][] requests, int index, int allow) {
        if (index >= requests.length) {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] != 0) {
                    return -1;
                }
            }
            return allow;
        }
        int from = requests[index][0];
        int to = requests[index][1];
        buildings[from]--;
        buildings[to]++;
        int result = backtrack(buildings, requests, index + 1, allow + 1);
        buildings[from]++;
        buildings[to]--;
        result = Math.max(backtrack(buildings, requests, index + 1, allow), result);
        return result;
    }
}
