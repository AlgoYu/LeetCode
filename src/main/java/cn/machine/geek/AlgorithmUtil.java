package cn.machine.geek;

import java.util.List;
import java.util.Objects;

/**
 * @Author XiaoYu
 * @Description 算法工具
 * @Date 2021/10/7 12:45 下午
 * @Email 794763733@qq.com
 */
public class AlgorithmUtil {
    // 负数概率
    private static final double NEGATIVE_PROBABILITY = 0.5;
    // 数字和字符字符串
    private static final String LETTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SIGN = "!\"#$%&‘()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String NUMBER = "0123456789";

    public static String generateRandomLetterString(int length) {
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(LETTER.charAt(generateRandomInt(LETTER.length() - 1, false)));
        }
        return sb.toString();
    }

    public static String generateRandomSignString(int length) {
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(SIGN.charAt(generateRandomInt(SIGN.length() - 1, false)));
        }
        return sb.toString();
    }

    /**
     * 随机数字字符串
     *
     * @param length
     * @return
     */
    public static String generateRandomNumberString(int length) {
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER.charAt(generateRandomInt(SIGN.length() - 1, false)));
        }
        return sb.toString();
    }

    public static String generateRandomString(double letter, double number, double sign, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (Math.random() < letter) {
                sb.append(generateRandomLetterString(generateRandomInt(length - sb.length(), false)));
            }
            if (Math.random() < number) {
                sb.append(generateRandomNumberString(generateRandomInt(length - sb.length(), false)));
            }
            if (Math.random() < sign) {
                sb.append(generateRandomSignString(generateRandomInt(length - sb.length(), false)));
            }
        }
        return sb.toString();
    }

    /**
     * List字符串对数器
     *
     * @param listA 字符串列表A
     * @param listB 字符串列表B
     * @return 是否相等
     */
    public static boolean isEqual(List<String> listA, List<String> listB) {
        if (listA == null && listB == null) {
            return true;
        }
        if (listA == null || listB == null) {
            return false;
        }
        if (listA.size() != listB.size()) {
            return false;
        }
        int n = listA.size();
        for (int i = 0; i < n; i++) {
            String sa = listA.get(i);
            String sb = listB.get(i);
            if (!Objects.equals(sa, sb)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成随机整形
     *
     * @param range    值范围
     * @param negative 是否包含负数域
     * @return 随机整数
     */
    public static int generateRandomInt(int range, boolean negative) {
        int result = (int) (Math.random() * range);
        if (negative && Math.random() < NEGATIVE_PROBABILITY) {
            result = -result;
        }
        return result;
    }

    public static int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
