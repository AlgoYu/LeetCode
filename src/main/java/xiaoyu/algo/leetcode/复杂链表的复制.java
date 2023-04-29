package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class 复杂链表的复制 {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node virtual = new Node(-1);
        Node current = virtual;

        Map<Node, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();

        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            current.next = new Node(tmp.val);
            list.add(current.next);
            map.put(tmp, index);
            current = current.next;
            tmp = tmp.next;
            index++;
        }

        tmp = head;
        current = virtual.next;
        while (tmp != null && current != null) {
            int i = map.getOrDefault(tmp.random, -1);
            current.random = i >= 0 ? list.get(i) : null;
            tmp = tmp.next;
            current = current.next;
        }

        return virtual.next;
    }
    /**
     *
     1991/2140

     智能模式







     3233343536373839404142434445464748
     int i = map.getOrDefault(tmp.random, -1);
     current.random = i >= 0 ? list.get(i) : null;
     tmp = tmp.next;
     current = current.next;
     }

     return virtual.next;
     }
     }
     测试用例
     代码执行结果
     调试器
     已完成
     执行用时：0 ms
     输入
     [[3,null],[3,0],[3,null]]
     输出
     [[3,null],[3,0],[3,null]]
     预期结果
     [[3,null],[3,0],[3,null]]
     控制台
     1 / 640

     剑指 Offer 35. 复杂链表的复制（哈希表 / 拼接与拆分，清晰图解）
     Krahets
     发布于 2020-11-07
     46.8k
     解题思路：
     普通链表的节点定义如下：


     // Definition for a Node.
     class Node {
     int val;
     Node next;
     public Node(int val) {
     this.val = val;
     this.next = null;
     }
     }
     本题链表的节点定义如下：


     // Definition for a Node.
     class Node {
     int val;
     Node next, random;
     public Node(int val) {
     this.val = val;
     this.next = null;
     this.random = null;
     }
     }
     给定链表的头节点 head ，复制普通链表很简单，只需遍历链表，每轮建立新节点 + 构建前驱节点 pre 和当前节点 node 的引用指向即可。

     本题链表的节点新增了 random 指针，指向链表中的 任意节点 或者 nullnull 。这个 random 指针意味着在复制过程中，除了构建前驱节点和当前节点的引用指向 pre.next ，还要构建前驱节点和其随机节点的引用指向 pre.random 。

     本题难点： 在复制链表的过程中构建新链表各节点的 random 引用指向。

     Picture1.png


     class Solution {
     public Node copyRandomList(Node head) {
     Node cur = head;
     Node dum = new Node(0), pre = dum;
     while(cur != null) {
     Node node = new Node(cur.val); // 复制节点 cur
     pre.next = node;               // 新链表的 前驱节点 -> 当前节点
     // pre.random = "???";         // 新链表的 「 前驱节点 -> 当前节点 」 无法确定
     cur = cur.next;                // 遍历下一节点
     pre = node;                    // 保存当前新节点
     }
     return dum.next;
     }
     }
     本文介绍 「哈希表」 ，「拼接 + 拆分」 两种方法。哈希表方法比较直观；拼接 + 拆分方法的空间复杂度更低。

     方法一：哈希表
     利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可。

     算法流程：
     若头节点 head 为空节点，直接返回 nullnull ；
     初始化： 哈希表 dic ， 节点 cur 指向头节点；
     复制链表：
     建立新节点，并向 dic 添加键值对 (原 cur 节点, 新 cur 节点） ；
     cur 遍历至原链表下一节点；
     构建新链表的引用指向：
     构建新节点的 next 和 random 引用指向；
     cur 遍历至原链表下一节点；
     返回值： 新链表的头节点 dic[cur] ；
     复杂度分析：
     时间复杂度 O(N)O(N) ： 两轮遍历链表，使用 O(N)O(N) 时间。
     空间复杂度 O(N)O(N) ： 哈希表 dic 使用线性大小的额外空间。


     代码：

     class Solution {
     public Node copyRandomList(Node head) {
     if(head == null) return null;
     Node cur = head;
     Map<Node, Node> map = new HashMap<>();
     // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
     while(cur != null) {
     map.put(cur, new Node(cur.val));
     cur = cur.next;
     }
     cur = head;
     // 4. 构建新链表的 next 和 random 指向
     while(cur != null) {
     map.get(cur).next = map.get(cur.next);
     map.get(cur).random = map.get(cur.random);
     cur = cur.next;
     }
     // 5. 返回新链表的头节点
     return map.get(head);
     }
     }
     方法二：拼接 + 拆分
     考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点。

     算法流程：
     复制各节点，构建拼接链表:

     设原链表为 node1 \rightarrow node2 \rightarrow \cdotsnode1→node2→⋯ ，构建的拼接链表如下所示：
     node1 \rightarrow node1_{new} \rightarrow node2 \rightarrow node2_{new} \rightarrow \cdots
     node1→node1
     new
     ​
     →node2→node2
     new
     ​
     →⋯

     构建新链表各节点的 random 指向：

     当访问原节点 cur 的随机指向节点 cur.random 时，对应新节点 cur.next 的随机指向节点为 cur.random.next 。
     拆分原 / 新链表：

     设置 pre / cur 分别指向原 / 新链表头节点，遍历执行 pre.next = pre.next.next 和 cur.next = cur.next.next 将两链表拆分开。
     返回新链表的头节点 res 即可。

     复杂度分析：
     时间复杂度 O(N)O(N) ： 三轮遍历链表，使用 O(N)O(N) 时间。
     空间复杂度 O(1)O(1) ： 节点引用变量使用常数大小的额外空间。


     代码：

     class Solution {
     public Node copyRandomList(Node head) {
     if(head == null) return null;
     Node cur = head;
     // 1. 复制各节点，并构建拼接链表
     while(cur != null) {
     Node tmp = new Node(cur.val);
     tmp.next = cur.next;
     cur.next = tmp;
     cur = tmp.next;
     }
     // 2. 构建各新节点的 random 指向
     cur = head;
     while(cur != null) {
     if(cur.random != null)
     cur.next.random = cur.random.next;
     cur = cur.next.next;
     }
     // 3. 拆分两链表
     cur = head.next;
     Node pre = head, res = head.next;
     while(cur.next != null) {
     pre.next = pre.next.next;
     cur.next = cur.next.next;
     pre = pre.next;
     cur = cur.next;
     }
     pre.next = null; // 单独处理原链表尾节点
     return res;      // 返回新链表头节点
     }
     }
     */
}
