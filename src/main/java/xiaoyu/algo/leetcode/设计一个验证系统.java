package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 设计一个验证系统 {
    private int timeToLive;
    private Map<String, Integer> map;

    public 设计一个验证系统(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = map.get(tokenId);
        if (time == null || currentTime - time >= timeToLive) {
            return;
        }
        map.put(tokenId, currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for (int n : map.values()) {
            if (currentTime - n < timeToLive) {
                cnt++;
            }
        }
        return cnt;
    }
}
