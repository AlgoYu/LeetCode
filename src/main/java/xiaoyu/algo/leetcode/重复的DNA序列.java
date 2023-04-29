package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/8 12:35 下午
 * @Email 794763733@qq.com
 */
public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequencesA(String s) {
        List<String> result = new ArrayList<String>();
        int n = s.length();
        if (n < 10) {
            return result;
        }
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i + 10 > n) {
                break;
            }
            String substring = s.substring(i, i + 10);
            if (map.get(substring) != null) {
                if (!map.get(substring)) {
                    result.add(substring);
                    map.put(substring, true);
                }
                continue;
            }
            map.put(substring, false);
        }
        return result;
    }
}
