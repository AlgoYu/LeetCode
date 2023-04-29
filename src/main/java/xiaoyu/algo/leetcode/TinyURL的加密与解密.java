package xiaoyu.algo.leetcode;

import java.util.*;

public class TinyURL的加密与解密 {
    Map<String, String> encodeMap;
    Map<String, String> decodeMap;
    private static final String PRE = "http://a.com/";
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random;

    public TinyURL的加密与解密() {
        random = new Random();
        this.encodeMap = new HashMap<>();
        this.decodeMap = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String randomStr = null;
        while (randomStr == null || decodeMap.containsKey(randomStr)) {
            randomStr = PRE + getRandomStr(random.nextInt(10));
        }
        encodeMap.put(longUrl, randomStr);
        decodeMap.put(randomStr, longUrl);
        return randomStr;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }

    private String getRandomStr(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(CHARS.charAt(number));
        }
        return sb.toString();
    }
}
