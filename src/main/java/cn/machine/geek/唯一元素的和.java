package cn.machine.geek;

public class 唯一元素的和 {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int total = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 1) {
                total += i;
            }
        }
        return total;
    }
}
