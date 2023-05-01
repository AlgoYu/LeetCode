package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 通知所有员工所需的时间 {
    int alreadyNotify;
    int n;
    int[] manager;
    int[] informTime;
    int headId;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        alreadyNotify = 0;
        this.n = n;
        this.headId = headID;
        this.manager = manager;
        this.informTime = informTime;
        int maxMinute = 0;
        for (int i = 0; i < manager.length; i++) {
            maxMinute = Math.max(getNotifyTime(i, 0), maxMinute);
        }
        return maxMinute;
    }

    private int getNotifyTime(int i, int curTime) {
        if (i == headId) {
            return curTime;
        }
        return getNotifyTime(manager[i], curTime + informTime[manager[i]]);
    }
}
