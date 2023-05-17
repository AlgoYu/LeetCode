package xiaoyu.algo.leetcode;

public class 判断两个事件是否存在冲突 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int startA = toMinutes(event1[0]);
        int endA = toMinutes(event1[1]);
        int startB = toMinutes(event2[0]);
        int endB = toMinutes(event2[1]);
        return !(endA < startB || endB < startA);
    }

    private int toMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
