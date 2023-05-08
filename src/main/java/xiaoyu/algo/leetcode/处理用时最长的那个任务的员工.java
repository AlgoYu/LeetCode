package xiaoyu.algo.leetcode;

public class 处理用时最长的那个任务的员工 {
    public int hardestWorker(int n, int[][] logs) {
        int pre = 0;
        int id = 0;
        int max = 0;
        for (int i = 0; i < logs.length; i++) {
            int value = logs[i][1] - pre;
            if (value >= max) {
                if (value == max) {
                    id = Math.min(id, logs[i][0]);
                } else {
                    id = logs[i][0];
                }
                max = value;
            }
            pre = logs[i][1];
        }
        return id;
    }
}
