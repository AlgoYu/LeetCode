package cn.machine.geek;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author XiaoYu
 * @Description
 * @Date 2021/10/5 3:06 下午
 * @Email 794763733@qq.com
 */
public class PeekingIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;

    public PeekingIterator(Iterator<Integer> iterator) {
        list = new LinkedList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        index = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
