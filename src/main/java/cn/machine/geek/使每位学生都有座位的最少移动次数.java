package cn.machine.geek;

import java.util.Arrays;
import java.util.Stack;

public class 使每位学生都有座位的最少移动次数 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < students.length; i++) {
            result += Math.abs(students[i] - seats[i]);
        }
        return result;
    }
}
