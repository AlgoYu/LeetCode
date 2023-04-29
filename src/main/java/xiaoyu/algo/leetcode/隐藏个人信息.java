package xiaoyu.algo.leetcode;

public class 隐藏个人信息 {
    public String maskPII(String s) {
        int i = s.indexOf('@');
        if (i != -1) {
            String[] split = s.split("@");
            String s1 = split[0].toLowerCase();
            return String.format("%s*****%s@%s", s1.charAt(0), s1.charAt(s1.length() - 1), split[1].toLowerCase());
        } else {
            String replace = s.replace("-", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace("+", "")
                    .replace(" ", "");
            int max = Math.min(3, Math.max(0, replace.length() - 10));
            StringBuilder sb = new StringBuilder();
            if (max > 0) {
                sb.append("+");
            }
            for (int k = 0; k < max; k++) {
                sb.append("*");
            }
            if (max > 0) {
                sb.append("-");
            }
            return String.format("%s***-***-%s", sb.toString(), replace.substring(replace.length() - 4));
        }
    }
}