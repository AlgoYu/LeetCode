package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/29 4:54 下午
 * @Email 794763733@qq.com
 */
public class 分糖果II {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int n = 0;
        while (candies > 0) {
            for (int i = 0; i < result.length; i++) {
                if (i + 1 + n > candies) {
                    result[i] = result[i] + candies;
                    candies = 0;
                    break;
                }
                result[i] = result[i] + i + 1 + n;
                candies = candies - (i + 1 + n);
            }
            n += num_people;
        }
        return result;
    }
}
