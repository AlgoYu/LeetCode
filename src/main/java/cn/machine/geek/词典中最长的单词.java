package cn.machine.geek;

import java.util.TreeMap;

public class 词典中最长的单词 {
    public String longestWord(String[] words) {
        DictionaryTree dictionaryTree = new DictionaryTree();
        for (String word : words) {
            dictionaryTree.add(word);
        }
        return dictionaryTree.getMax();
    }

    class DictionaryTree {
        Node root;

        public DictionaryTree() {
            root = new Node();
            root.word = "";
        }

        public void add(String word) {
            Node cur = root;
            int i = 0;
            int n = word.length();
            while (i < n) {
                char ch = word.charAt(i);
                Node node = cur.children.get(ch);
                if (node == null) {
                    node = new Node();
                    cur.children.put(ch, node);
                }
                cur = node;
                i++;
            }
            cur.isWord = true;
            cur.word = word;
        }

        public String getMax() {
            return getDeep(root);
        }

        private String getDeep(Node cur) {
            String result = cur.word;
            // 已经到底了
            if (cur.children.size() == 0) {
                return cur.word;
            }
            for (Node node : cur.children.values()) {
                // 不是word，不可能是一个字母一个字母加的答案，略过
                if (!node.isWord) {
                    continue;
                }
                String deep = getDeep(node);
                if (deep.length() > result.length()) {
                    result = deep;
                }
            }
            return result;
        }

        class Node {
            String word;
            boolean isWord;
            TreeMap<Character, Node> children = new TreeMap<>();
        }
    }
}
