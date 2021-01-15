package cn.machine.geek;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class 合并两个排序的链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            next = null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            if(l1 == null){
                return l2;
            }else{
                return l1;
            }
        }
        ListNode temp = new ListNode(0);
        ListNode flag = temp;
        while (true){
            if(l1.val > l2.val){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
            if(l1 == null){
                temp.next = l2;
                break;
            }
            if(l2 == null){
                temp.next = l1;
                break;
            }
        }
        return flag.next;
    }
    /**
     * 解题思路：
     * 根据题目描述， 链表 l_1l
     * 1
     * ​
     *   , l_2l
     * 2
     * ​
     *   是 递增 的，因此容易想到使用双指针 l_1l
     * 1
     * ​
     *   和 l_2l
     * 2
     * ​
     *   遍历两链表，根据 l_1.vall
     * 1
     * ​
     *  .val 和 l_2.vall
     * 2
     * ​
     *  .val 的大小关系确定节点添加顺序，两节点指针交替前进，直至遍历完毕。
     *
     * 引入伪头节点： 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。解决方案：初始化一个辅助节点 dumdum 作为合并链表的伪头节点，将各节点添加至 dumdum 之后。
     *
     *
     *
     * 算法流程：
     * 初始化： 伪头节点 dumdum ，节点 curcur 指向 dumdum 。
     * 循环合并： 当 l_1l
     * 1
     * ​
     *   或 l_2l
     * 2
     * ​
     *   为空时跳出；
     * 当 l_1.val < l_2.vall
     * 1
     * ​
     *  .val<l
     * 2
     * ​
     *  .val 时： curcur 的后继节点指定为 l_1l
     * 1
     * ​
     *   ，并 l_1l
     * 1
     * ​
     *   向前走一步；
     * 当 l_1.val \geq l_2.vall
     * 1
     * ​
     *  .val≥l
     * 2
     * ​
     *  .val 时： curcur 的后继节点指定为 l_2l
     * 2
     * ​
     *   ，并 l_2l
     * 2
     * ​
     *   向前走一步 ；
     * 节点 curcur 向前走一步，即 cur = cur.nextcur=cur.next 。
     * 合并剩余尾部： 跳出时有两种情况，即 l_1l
     * 1
     * ​
     *   为空 或 l_2l
     * 2
     * ​
     *   为空。
     * 若 l_1 \ne nulll
     * 1
     * ​
     *
     * 
     * ​
     *  =null ： 将 l_1l
     * 1
     * ​
     *   添加至节点 curcur 之后；
     * 否则： 将 l_2l
     * 2
     * ​
     *   添加至节点 curcur 之后。
     * 返回值： 合并链表在伪头节点 dumdum 之后，因此返回 dum.nextdum.next 即可。
     *
     * 1 / 16
     *
     * 复杂度分析：
     * 时间复杂度 O(M+N)O(M+N) ： M, NM,N 分别为链表 l_1l
     * 1
     * ​
     *  , l_2l
     * 2
     * ​
     *   的长度，合并操作需遍历两链表。
     * 空间复杂度 O(1)O(1) ： 节点引用 dumdum , curcur 使用常数大小的额外空间。
     * 代码：
     * Python 三元表达式写法 A if x else B ，代表当 x = Truex=True 时执行 AA ，否则执行 BB 。
     *
     * pythonjava
     *
     * class Solution {
     *     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     *         ListNode dum = new ListNode(0), cur = dum;
     *         while(l1 != null && l2 != null) {
     *             if(l1.val < l2.val) {
     *                 cur.next = l1;
     *                 l1 = l1.next;
     *             }
     *             else {
     *                 cur.next = l2;
     *                 l2 = l2.next;
     *             }
     *             cur = cur.next;
     *         }
     *         cur.next = l1 != null ? l1 : l2;
     *         return dum.next;
     *     }
     * }
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/solution/mian-shi-ti-25-he-bing-liang-ge-pai-xu-de-lian-b-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
