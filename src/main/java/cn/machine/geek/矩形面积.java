package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/30 2:57 下午
 * @Email 794763733@qq.com
 */
public class 矩形面积 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // A面积
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        // B面积
        int areaB = (bx2 - bx1) * (by2 - by1);
        // 获取覆盖面积
        int overlapLong = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapWid = Math.min(ay2, by2) - Math.max(ay1, by1);
        // 只要有一个是负数，就不会覆盖
        int overlapArea = Math.max(overlapLong, 0) * Math.max(overlapWid, 0);
        return areaA + areaB - overlapArea;
    }
}
