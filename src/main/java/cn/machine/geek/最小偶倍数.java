package cn.machine.geek;

public class 最小偶倍数 {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
