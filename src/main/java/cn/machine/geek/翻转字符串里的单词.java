package cn.machine.geek;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 *
 * 进阶：
 *
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        if(s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        int index = 0;
        int len = 0;
        boolean space = true;
        for (int i = 0; i < chars.length; i++){
            if(chars[i] != ' '){
                chars[index++] = chars[i];
                space = false;
            }else if(!space){
                chars[index++] = ' ';
                space = true;
            }
        }
        len = space? index - 1 : index;
        reverse(chars,0,len - 1);
        int l = 0;
        for (int i = 0; i <= len;i++){
            if(i == len || chars[i] == ' '){
                reverse(chars,l,i - 1);
                l = i + 1;
            }
        }
        return new String(chars,0,len);
    }

    private void reverse(char[] array,int left,int right){
        char temp;
        while (left < right){
            temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
    }
    /**
     * 解题思路
     * 此处撰写解题思路
     *
     * 代码
     *
     * class Solution {
     * public:
     *     string reverseWords(string s) {
     * 	string t = "";
     * 	int i,len = s.length();
     * 	**for(i=0;i<len;i++){
     * 	   if(s[i]!=' ') break;
     *        }**
     * 	string y="";
     * 	for(;i<len;i++){
     * 		**if(y.length()&&s[i]==' '){
     * 			if(t.length()) t= " "+t;**
     * 			t=y+t;
     * 			y="";
     *        }
     * 		else if(s[i]!=' '){
     * 			y+=s[i];
     *        }
     * //	        cout<<y<<endl;
     *    }
     * 	if(y.length()){
     *         if(t.length()) t=" "+t;
     *         t=y+t;
     *     }
     *     return t;
     * ![...-10 22-03-57-952.mp4](bf888c18-beb5-4024-b31b-c21bc81fb8ed)
     *     }
     * };
     *
     * 作者：chaiyinlei
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/ba-mei-ge-zi-fu-chu-li-chu-lai-jiu-xing-liao-zhu-y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
