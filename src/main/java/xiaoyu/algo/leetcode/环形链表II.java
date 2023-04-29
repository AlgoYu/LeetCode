package xiaoyu.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class 环形链表II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        Map<Object, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.get(head) != null) {
                return head;
            }
            map.put(head, 1);
            head = head.next;
        }
        return null;
    }
    /**
     * 方法一：哈希表
     * 思路与算法
     *
     * 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现。
     *
     * 代码
     *
     * C++JavaCJavaScriptGolang
     *
     * public class Solution {
     *     public ListNode detectCycle(ListNode head) {
     *         ListNode pos = head;
     *         Set<ListNode> visited = new HashSet<ListNode>();
     *         while (pos != null) {
     *             if (visited.contains(pos)) {
     *                 return pos;
     *             } else {
     *                 visited.add(pos);
     *             }
     *             pos = pos.next;
     *         }
     *         return null;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 为链表中节点的数目。我们恰好需要访问链表中的每一个节点。
     *
     * 空间复杂度：O(N)O(N)，其中 NN 为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
     *
     * 方法二：快慢指针
     * 思路与算法
     *
     * 我们使用两个指针，\textit{fast}fast 与 \textit{slow}slow。它们起始都位于链表的头部。随后，\textit{slow}slow 指针每次向后移动一个位置，而 \textit{fast}fast 指针向后移动两个位置。如果链表中存在环，则 \textit{fast}fast 指针最终将再次与 \textit{slow}slow 指针在环中相遇。
     *
     * 如下图所示，设链表中环外部分的长度为 aa。\textit{slow}slow 指针进入环后，又走了 bb 的距离与 \textit{fast}fast 相遇。此时，\textit{fast}fast 指针已经走完了环的 nn 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nc。
     *
     *
     *
     * 根据题意，任意时刻，\textit{fast}fast 指针走过的距离都为 \textit{slow}slow 指针的 22 倍。因此，我们有
     *
     * a+(n+1)b+nc=2(a+b) \implies a=c+(n-1)(b+c)
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     *
     * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     *
     * 因此，当发现 \textit{slow}slow 与 \textit{fast}fast 相遇时，我们再额外使用一个指针 \textit{ptr}ptr。起始，它指向链表头部；随后，它和 \textit{slow}slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * 代码
     *
     * C++JavaCJavaScriptGolang
     *
     * public class Solution {
     *     public ListNode detectCycle(ListNode head) {
     *         if (head == null) {
     *             return null;
     *         }
     *         ListNode slow = head, fast = head;
     *         while (fast != null) {
     *             slow = slow.next;
     *             if (fast.next != null) {
     *                 fast = fast.next.next;
     *             } else {
     *                 return null;
     *             }
     *             if (fast == slow) {
     *                 ListNode ptr = head;
     *                 while (ptr != slow) {
     *                     ptr = ptr.next;
     *                     slow = slow.next;
     *                 }
     *                 return ptr;
     *             }
     *         }
     *         return null;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 为链表中节点的数目。在最初判断快慢指针是否相遇时，\textit{slow}slow 指针走过的距离不会超过链表的总长度；随后寻找入环点时，走过的距离也不会超过链表的总长度。因此，总的执行时间为 O(N)+O(N)=O(N)O(N)+O(N)=O(N)。
     *
     * 空间复杂度：O(1)O(1)。我们只使用了 \textit{slow}, \textit{fast}, \textit{ptr}slow,fast,ptr 三个指针。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
