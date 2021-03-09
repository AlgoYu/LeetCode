package cn.machine.geek;

/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 */
public class 反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            while (left < right && !match(chars[left])){
                left++;
            }
            while (left < right && !match(chars[right])){
                right--;
            }
            if(left == right){
                break;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean match(char ch){
        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
            return true;
        }
        return false;
    }
}
