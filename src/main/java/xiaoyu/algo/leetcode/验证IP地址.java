package xiaoyu.algo.leetcode;


public class 验证IP地址 {

    /**
     * 这个有一个测试用例没过，但是我没明白是为什么。
     * f:f:f:f:f:f:f:f 不是一个有效的IPV6地址。
     */
    public String validIPAddress(String queryIP) {
        int n = queryIP.length();
        if (n == 0) {
            return "Neither";
        }
        if (n > 15 && isIpV6(queryIP, n)) {
            return "IPv6";
        }

        if (isIpV4(queryIP, n)) {
            return "IPv4";
        }

        return "Neither";
    }

    private boolean isIpV4(String ip, int n) {
        int index = 0;
        int segmentNum = 0;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            char c = ip.charAt(index);
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
            if (c == '.') {
                if (index == 0 || index == n - 1) {
                    return false;
                }
                String s = sb.toString();
                if (!isValidIpV4Segment(s)) {
                    return false;
                }
                sb.delete(0, sb.length());
                segmentNum++;
            } else {
                sb.append(c);
            }
            index++;
        }
        if (sb.length() > 0) {
            segmentNum++;
            return segmentNum == 4 && isValidIpV4Segment(sb.toString());
        }
        return segmentNum == 4;
    }

    private boolean isValidIpV4Segment(String s) {
        if (s.length() <= 0 || s.length() > 3) {
            return false;
        }
        int value = Integer.parseInt(s);
        if (value < 0 || value > 255) {
            return false;
        }
        if (value < Math.pow(10F, s.length() - 1)) {
            return false;
        }
        return true;
    }

    private boolean isIpV6(String ip, int n) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int segmentNum = 0;
        while (index < n) {
            char c = ip.charAt(index);
            if (Character.isLetter(c) && Character.toLowerCase(c) > 'f') {
                return false;
            }
            if (c == ':') {
                if (index == 0 || index == n - 1) {
                    return false;
                }
                String s = sb.toString();
                if (!isValidIpV6Segment(s)) {
                    return false;
                }
                sb.delete(0, sb.length());
                segmentNum++;
            } else {
                sb.append(c);
            }
            index++;
        }
        if (sb.length() > 0) {
            segmentNum++;
            return segmentNum == 8 && isValidIpV6Segment(sb.toString());
        }
        return segmentNum == 8;
    }

    private boolean isValidIpV6Segment(String s) {
        if (s.length() <= 0 || s.length() > 4) {
            return false;
        }
        return true;
    }
}
