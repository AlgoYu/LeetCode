package xiaoyu.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 最长快乐字符串 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        List<Node> list = new ArrayList<>(3);
        list.add(new Node('a', a));
        list.add(new Node('b', b));
        list.add(new Node('c', c));
        list.sort(((o1, o2) -> {
            return o2.num - o1.num;
        }));
        int pre = ' ';
        for (; ; ) {
            Node first = list.get(0);
            if (first.num <= 0) {
                break;
            }
            if (first.ch == pre) {
                Node second = list.get(1);
                if (second.num <= 0) {
                    break;
                }
                sb.append(second.ch);
                second.num--;
                pre = second.ch;
            } else {
                for (int i = 0; i < 2 && first.num > 0; i++) {
                    first.num--;
                    sb.append(first.ch);
                }
                pre = first.ch;
            }
            list.sort(((o1, o2) -> {
                return o2.num - o1.num;
            }));
        }
        return sb.toString();
    }

    class Node {
        char ch;
        int num;

        public Node(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }
}
