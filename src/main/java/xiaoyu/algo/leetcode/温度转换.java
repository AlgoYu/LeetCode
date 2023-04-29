package xiaoyu.algo.leetcode;

class 温度转换 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15D, celsius * 1.80 + 32.00};
    }
}