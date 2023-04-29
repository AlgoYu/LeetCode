package xiaoyu.algo.leetcode;

public class 复数乘法 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+");
        String[] split2 = num2.split("\\+");
        Integer real1 = Integer.parseInt(split1[0]);
        Integer real2 = Integer.parseInt(split2[0]);
        Integer virtual1 = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        Integer virtual2 = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));
        return String.format("%d+%di", real1 * real2 - virtual1 * virtual2, virtual1 * real2 + real1 * virtual2);
    }
}
