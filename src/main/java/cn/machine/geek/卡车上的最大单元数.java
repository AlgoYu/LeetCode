package cn.machine.geek;

import java.util.Arrays;

public class 卡车上的最大单元数 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> {
            return o2[1] - o1[1];
        });
        int total = 0;
        int index = 0;
        while (truckSize > 0 && index < boxTypes.length) {
            while (truckSize > 0 && boxTypes[index][0] > 0) {
                boxTypes[index][0]--;
                truckSize--;
                total += boxTypes[index][1];
            }
            index++;
        }
        return total;
    }
}