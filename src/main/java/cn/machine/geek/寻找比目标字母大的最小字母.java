package cn.machine.geek;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/13 5:57 下午
 * @Email 794763733@qq.com
 */
public class 寻找比目标字母大的最小字母 {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == n ? letters[0] : letters[left];
    }

}
