package com.leetcode;

public class DesignAddAndSearchWordDataStructure {
    TrieNode root;

    public DesignAddAndSearchWordDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchWithIdx(0, word, root);
    }

    public boolean searchWithIdx(int idx, String word, TrieNode node) {
        if (idx == word.length()) return node.isEnd;
        char c = word.charAt(idx);
        if (c != '.') {
            if (node.children[c - 'a'] == null) return false;
            return searchWithIdx(idx + 1, word, node.children[c - 'a']);
        } else {
            boolean found = false;
            for (TrieNode other : node.children) {
                if (other == null) continue;
                found = searchWithIdx(idx + 1, word, other);
                if (found) return true;
            }
        }
        return false;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}
