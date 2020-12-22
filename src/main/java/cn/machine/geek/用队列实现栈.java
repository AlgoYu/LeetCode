package cn.machine.geek;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class 用队列实现栈 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public 用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.isEmpty()){
            return -1;
        }
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        if(queue1.isEmpty()){
            return -1;
        }
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    /**
     * 绪论
     * 这道题目是为初级读者准备的，题目涉及到栈和队列两种数据结构。
     *
     * 栈是一种后进先出的数据结构，元素从顶端入栈，然后从顶端出栈。
     *
     * 队列是一种先进先出的数据结构，元素从后端入队，然后从前端出队。
     *
     * 方法一：两个队列
     * 为了满足栈的特性，即最后入栈的元素最先出栈，在使用队列实现栈时，应满足队列前端的元素是最后入栈的元素。可以使用两个队列实现栈的操作，其中 \textit{queue}_1queue
     * 1
     * ​
     *   用于存储栈内的元素，\textit{queue}_2queue
     * 2
     * ​
     *   作为入栈操作的辅助队列。
     *
     * 入栈操作时，首先将元素入队到 \textit{queue}_2queue
     * 2
     * ​
     *  ，然后将 \textit{queue}_1queue
     * 1
     * ​
     *   的全部元素依次出队并入队到 \textit{queue}_2queue
     * 2
     * ​
     *  ，此时 \textit{queue}_2queue
     * 2
     * ​
     *   的前端的元素即为新入栈的元素，再将 \textit{queue}_1queue
     * 1
     * ​
     *   和 \textit{queue}_2queue
     * 2
     * ​
     *   互换，则 \textit{queue}_1queue
     * 1
     * ​
     *   的元素即为栈内的元素，\textit{queue}_1queue
     * 1
     * ​
     *   的前端和后端分别对应栈顶和栈底。
     *
     * 由于每次入栈操作都确保 \textit{queue}_1queue
     * 1
     * ​
     *   的前端元素为栈顶元素，因此出栈操作和获得栈顶元素操作都可以简单实现。出栈操作只需要移除 \textit{queue}_1queue
     * 1
     * ​
     *   的前端元素并返回即可，获得栈顶元素操作只需要获得 \textit{queue}_1queue
     * 1
     * ​
     *   的前端元素并返回即可（不移除元素）。
     *
     * 由于 \textit{queue}_1queue
     * 1
     * ​
     *   用于存储栈内的元素，判断栈是否为空时，只需要判断 \textit{queue}_1queue
     * 1
     * ​
     *   是否为空即可。
     *
     *
     *
     * JavaC++Python3GolangC
     *
     * class MyStack {
     *     Queue<Integer> queue1;
     *     Queue<Integer> queue2;
     *
     *     public MyStack() {
     *         queue1 = new LinkedList<Integer>();
     *         queue2 = new LinkedList<Integer>();
     *     }
     *
     *     public void push(int x) {
     *         queue2.offer(x);
     *         while (!queue1.isEmpty()) {
     *             queue2.offer(queue1.poll());
     *         }
     *         Queue<Integer> temp = queue1;
     *         queue1 = queue2;
     *         queue2 = temp;
     *     }
     *
     *     public int pop() {
     *         return queue1.poll();
     *     }
     *
     *     public int top() {
     *         return queue1.peek();
     *     }
     *
     *     public boolean empty() {
     *         return queue1.isEmpty();
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：入栈操作 O(n)O(n)，其余操作都是 O(1)O(1)。
     * 入栈操作需要将 \textit{queue}_1queue
     * 1
     * ​
     *   中的 nn 个元素出队，并入队 n+1n+1 个元素到 \textit{queue}_2queue
     * 2
     * ​
     *  ，共有 2n+12n+1 次操作，每次出队和入队操作的时间复杂度都是 O(1)O(1)，因此入栈操作的时间复杂度是 O(n)O(n)。
     * 出栈操作对应将 \textit{queue}_1queue
     * 1
     * ​
     *   的前端元素出队，时间复杂度是 O(1)O(1)。
     * 获得栈顶元素操作对应获得 \textit{queue}_1queue
     * 1
     * ​
     *   的前端元素，时间复杂度是 O(1)O(1)。
     * 判断栈是否为空操作只需要判断 \textit{queue}_1queue
     * 1
     * ​
     *   是否为空，时间复杂度是 O(1)O(1)。
     *
     * 空间复杂度：O(n)O(n)，其中 nn 是栈内的元素。需要使用两个队列存储栈内的元素。
     *
     * 方法二：一个队列
     * 方法一使用了两个队列实现栈的操作，也可以使用一个队列实现栈的操作。
     *
     * 使用一个队列时，为了满足栈的特性，即最后入栈的元素最先出栈，同样需要满足队列前端的元素是最后入栈的元素。
     *
     * 入栈操作时，首先获得入栈前的元素个数 nn，然后将元素入队到队列，再将队列中的前 nn 个元素（即除了新入栈的元素之外的全部元素）依次出队并入队到队列，此时队列的前端的元素即为新入栈的元素，且队列的前端和后端分别对应栈顶和栈底。
     *
     * 由于每次入栈操作都确保队列的前端元素为栈顶元素，因此出栈操作和获得栈顶元素操作都可以简单实现。出栈操作只需要移除队列的前端元素并返回即可，获得栈顶元素操作只需要获得队列的前端元素并返回即可（不移除元素）。
     *
     * 由于队列用于存储栈内的元素，判断栈是否为空时，只需要判断队列是否为空即可。
     *
     *
     *
     * JavaC++Python3GolangC
     *
     * class MyStack {
     *     Queue<Integer> queue;
     *
     *     public MyStack() {
     *         queue = new LinkedList<Integer>();
     *     }
     *
     *     public void push(int x) {
     *         int n = queue.size();
     *         queue.offer(x);
     *         for (int i = 0; i < n; i++) {
     *             queue.offer(queue.poll());
     *         }
     *     }
     *
     *     public int pop() {
     *         return queue.poll();
     *     }
     *
     *     public int top() {
     *         return queue.peek();
     *     }
     *
     *     public boolean empty() {
     *         return queue.isEmpty();
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：入栈操作 O(n)O(n)，其余操作都是 O(1)O(1)。
     * 入栈操作需要将队列中的 nn 个元素出队，并入队 n+1n+1 个元素到队列，共有 2n+12n+1 次操作，每次出队和入队操作的时间复杂度都是 O(1)O(1)，因此入栈操作的时间复杂度是 O(n)O(n)。
     * 出栈操作对应将队列的前端元素出队，时间复杂度是 O(1)O(1)。
     * 获得栈顶元素操作对应获得队列的前端元素，时间复杂度是 O(1)O(1)。
     * 判断栈是否为空操作只需要判断队列是否为空，时间复杂度是 O(1)O(1)。
     *
     * 空间复杂度：O(n)O(n)，其中 nn 是栈内的元素。需要使用一个队列存储栈内的元素。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}