package xiaoyu.algo.leetcode;

import java.util.List;

public class 统计匹配检索规则的物品数量 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }
        int total = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) {
                total++;
            }
        }
        return total;
    }
}