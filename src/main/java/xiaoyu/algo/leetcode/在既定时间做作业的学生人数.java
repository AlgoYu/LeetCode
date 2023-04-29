package xiaoyu.algo.leetcode;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/11/1 11:10 上午
 * @Email 794763733@qq.com
 */
public class 在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] > queryTime) {
                continue;
            }
            if (endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
