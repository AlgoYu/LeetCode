package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/9/22 5:43 下午
 * @Email 794763733@qq.com
 */
public class 链表分割 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> listNodes = toList(head);
        ListNode[] result = new ListNode[k];
        if (listNodes.size() == 0) {
            return result;
        }
        int n = listNodes.size();
        int max = n / k;
        int offset = n % k;
        int index = 0;
        for (int i = 0; i < k && index < n; i++) {
            result[i] = listNodes.get(index);
            index = index + max + (i < offset ? 1 : 0) - 1;
            if (index < n) {
                listNodes.get(index).next = null;
            }
            index++;
        }
        return result;
    }

    private List<ListNode> toList(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        return list;
    }

}
