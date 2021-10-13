package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/13 5:57 下午
 * @Email 794763733@qq.com
 */
public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (target >= letters[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left >= letters.length || left <= 0 ? letters[0] : letters[left];
    }

    public static void main(String[] args) {
        寻找比目标字母大的最小字母 test = new 寻找比目标字母大的最小字母();
        test.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd');
    }
}
