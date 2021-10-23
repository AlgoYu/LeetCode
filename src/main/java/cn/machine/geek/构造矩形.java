package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/23 12:50 下午
 * @Email 794763733@qq.com
 */
public class 构造矩形 {
    public int[] constructRectangle(int area) {
        int W = area == 1 ? 1 : area / 2;
        while (area % W != 0 || area / W < W) {
            W--;
        }
        return new int[]{area / W, W};
    }
}
