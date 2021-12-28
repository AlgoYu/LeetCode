package cn.machine.geek;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 连接词 {

    public static void main(String[] args) {
        连接词 test = new 连接词();
        test.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"});
    }

    class Node {
        boolean end;
        String word;
        Node[] children;

        public Node() {
            children = new Node[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        Arrays.sort(words, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }
            if (dfs(trie.root, word, 0)) {
                result.add(word);
            } else {
                trie.addWord(word);
            }
        }
        return result;
    }

    // dfs
    public boolean dfs(Node node, String word, int start) {
        if (node == null || start >= word.length()) {
            return true;
        }
        Node cur = node;
        for (int i = start; i < word.length(); i++) {
            cur = cur.children[word.charAt(i) - 'a'];
            if (cur == null) {
                return false;
            }
            if (cur.end && dfs(node, word, i + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字典树
     */
    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Node node = cur.children[ch - 'a'];
                if (node == null) {
                    node = new Node();
                    cur.children[ch - 'a'] = node;
                }
                cur = node;
            }
            cur.end = true;
            cur.word = word;
        }
    }
}
