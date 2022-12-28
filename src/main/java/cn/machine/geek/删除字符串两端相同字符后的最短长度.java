package cn.machine.geek;

public class 删除字符串两端相同字符后的最短长度 {
    public int minimumLength(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char c = s.charAt(l);
            while (l <= r && s.charAt(l) == c) {
                l++;
            }
            while (l <= r && s.charAt(r) == c) {
                r--;
            }
        }
        return r - l + 1;
    }
}
