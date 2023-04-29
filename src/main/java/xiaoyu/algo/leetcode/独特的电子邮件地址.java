package xiaoyu.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class 独特的电子邮件地址 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            String[] split = email.split("@");
            if (split.length < 2) {
                continue;
            }
            split[0] = split[0].replaceAll("\\.", "");
            int index = split[0].indexOf("+");
            if (index > 0) {
                split[0] = split[0].substring(0, index);
            }
            sb.append(split[0]).append("@").append(split[1]);
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return set.size();
    }
}
