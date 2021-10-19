package cn.machine.geek;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/10/19 10:37 上午
 * @Email 794763733@qq.com
 */
public class 添加与搜索单词数据结构设计 {
    Trie trie;

    public 添加与搜索单词数据结构设计() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.contains(word);
    }

    class Trie {
        boolean end;
        Map<Character, Trie> children;

        public Trie() {
            this.end = false;
            this.children = new HashMap<>();
        }

        public void add(String text) {
            Trie node = this;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                Trie trie = node.children.get(c);
                if (trie == null) {
                    trie = new Trie();
                    node.children.put(c, trie);
                }
                node = trie;
            }
            node.end = true;
        }

        public boolean contains(String text) {
            Trie node = this;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == '.') {
                    return dfs(node, i, text);
                }
                Trie trie = node.children.get(c);
                if (trie == null) {
                    return false;
                }
                node = trie;
            }
            return node.end;
        }

        private boolean dfs(Trie node, int index, String text) {
            if (node == null) {
                return false;
            }
            if (index == text.length()) {
                return node.end;
            }
            if (text.charAt(index) == '.') {
                for (Trie child : node.children.values()) {
                    boolean dfs = dfs(child, index + 1, text);
                    if (dfs) {
                        return dfs;
                    }
                }
            }
            return dfs(node.children.get(text.charAt(index)), index + 1, text);
        }

        public boolean isEnd() {
            return end;
        }
    }
}
