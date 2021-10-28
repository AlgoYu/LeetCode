package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/28 10:26 上午
 * @Email 794763733@qq.com
 */
public class 重新排序得到2的幂 {
    public boolean reorderedPowerOf2(int n) {
        if (isPower(n)) {
            return true;
        }
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        return backtrack(chars, 0);
    }

    private boolean backtrack(char[] chars, int index) {
        if (index >= chars.length) {
            int result = Integer.parseInt(new String(chars));
            if (isPower(result)) {
                return true;
            }
            return false;
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '0' && index == 0) {
                continue;
            }
            swap(chars, index, i);
            if (backtrack(chars, index + 1)) {
                return true;
            }
            swap(chars, index, i);
        }
        return false;
    }

    private void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    private boolean isPower(int n) {
        if (n == 1) {
            return true;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        重新排序得到2的幂 test = new 重新排序得到2的幂();
        System.out.println(test.reorderedPowerOf2(4609));
    }
}
