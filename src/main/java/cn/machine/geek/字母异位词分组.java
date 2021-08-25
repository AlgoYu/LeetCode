package cn.machine.geek;

import java.util.*;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/8/25 7:41 下午
 * @Email 794763733@qq.com
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.put(key, strings);
        }
        return new ArrayList<>(map.values());
    }
}
