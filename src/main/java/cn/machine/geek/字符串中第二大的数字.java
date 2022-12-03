package cn.machine.geek;

public class 字符串中第二大的数字 {
    public int secondHighest(String s) {
        int first = -1;
        int secound = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int temp = c - '0';
                if (temp > first) {
                    secound = first;
                    first = temp;
                } else if (temp < first && temp > secound) {
                    secound = temp;
                }
            }
        }
        return secound;
    }
}