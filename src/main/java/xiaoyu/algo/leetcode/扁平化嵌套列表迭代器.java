package xiaoyu.algo.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class 扁平化嵌套列表迭代器 implements Iterator<Integer> {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private List<Integer> list;
    private int current;

    public 扁平化嵌套列表迭代器(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        dfs(nestedList);
        if (list.size() > 0) {
            current = 0;
        }
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < list.size();
    }

    /**
     * 方法一：深度优先搜索
     * 思路
     *
     * 嵌套的整型列表是一个树形结构，树上的叶子节点对应一个整数，非叶节点对应一个列表。
     *
     * 在这棵树上深度优先搜索的顺序就是迭代器遍历的顺序。
     *
     * 我们可以先遍历整个嵌套列表，将所有整数存入一个数组，然后遍历该数组从而实现 \texttt{next}next 和 \texttt{hasNext}hasNext 方法。
     *
     * 代码
     *
     * C++JavaGolangJavaScriptC
     *
     * public class NestedIterator implements Iterator<Integer> {
     *     private List<Integer> vals;
     *     private Iterator<Integer> cur;
     *
     *     public NestedIterator(List<NestedInteger> nestedList) {
     *         vals = new ArrayList<Integer>();
     *         dfs(nestedList);
     *         cur = vals.iterator();
     *     }
     *
     *     @Override
     *     public Integer next() {
     *         return cur.next();
     *     }
     *
     *     @Override
     *     public boolean hasNext() {
     *         return cur.hasNext();
     *     }
     *
     *     private void dfs(List<NestedInteger> nestedList) {
     *         for (NestedInteger nest : nestedList) {
     *             if (nest.isInteger()) {
     *                 vals.add(nest.getInteger());
     *             } else {
     *                 dfs(nest.getList());
     *             }
     *         }
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：初始化为 O(n)O(n)，\texttt{next}next 和 \texttt{hasNext}hasNext 为 O(1)O(1)。其中 nn 是嵌套的整型列表中的元素个数。
     *
     * 空间复杂度：O(n)O(n)。需要一个数组存储嵌套的整型列表中的所有元素。
     *
     * 方法二：栈
     * 思路
     *
     * 我们可以用一个栈来代替方法一中的递归过程。
     *
     * 具体来说，用一个栈来维护深度优先搜索时，从根节点到当前节点路径上的所有节点。由于非叶节点对应的是一个列表，我们在栈中存储的是指向列表当前遍历的元素的指针（下标）。每次向下搜索时，取出列表的当前指针指向的元素并将其入栈，同时将该指针向后移动一位。如此反复直到找到一个整数。循环时若栈顶指针指向了列表末尾，则将其从栈顶弹出。
     *
     * 下面的代码中，\texttt{C++}C++ 和 \texttt{Java}Java 的栈存储的是迭代器，迭代器可以起到指向元素的指针的效果，\texttt{Go}Go 的栈存储的是切片（视作队列），通过将元素弹出队首的操作代替移动指针的操作。
     *
     * 代码
     *
     * C++JavaGolangJavaScript
     *
     * public class NestedIterator implements Iterator<Integer> {
     *     // 存储列表的当前遍历位置
     *     private Deque<Iterator<NestedInteger>> stack;
     *
     *     public NestedIterator(List<NestedInteger> nestedList) {
     *         stack = new LinkedList<Iterator<NestedInteger>>();
     *         stack.push(nestedList.iterator());
     *     }
     *
     *     @Override
     *     public Integer next() {
     *         // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
     *         return stack.peek().next().getInteger();
     *     }
     *
     *     @Override
     *     public boolean hasNext() {
     *         while (!stack.isEmpty()) {
     *             Iterator<NestedInteger> it = stack.peek();
     *             if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
     *                 stack.pop();
     *                 continue;
     *             }
     *             // 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
     *             NestedInteger nest = it.next();
     *             if (nest.isInteger()) {
     *                 List<NestedInteger> list = new ArrayList<NestedInteger>();
     *                 list.add(nest);
     *                 stack.push(list.iterator());
     *                 return true;
     *             }
     *             stack.push(nest.getList().iterator());
     *         }
     *         return false;
     *     }
     * }
     * 复杂度分析
     *
     * 时间复杂度：初始化和 \texttt{next}next 为 O(1)O(1)，\texttt{hasNext}hasNext 为均摊 O(1)O(1)。
     *
     * 空间复杂度：O(n)O(n)。最坏情况下嵌套的整型列表是一条链，我们需要一个 O(n)O(n) 大小的栈来存储链上的所有元素。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/bian-ping-hua-qian-tao-lie-biao-die-dai-ipjzq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
