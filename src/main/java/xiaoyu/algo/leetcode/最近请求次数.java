package xiaoyu.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/25 7:36 下午
 * @Email 794763733@qq.com
 */
public class 最近请求次数 {
    Queue<Integer> queue;

    public 最近请求次数() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
