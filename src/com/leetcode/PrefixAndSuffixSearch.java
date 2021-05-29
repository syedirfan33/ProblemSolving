package com.leetcode;

public class PrefixAndSuffixSearch {
    TrieNode root;

    public PrefixAndSuffixSearch(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int j = 0; j < cur.length(); j++) {
                root.insert(cur.substring(j, cur.length()) + "{" + cur, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return root.getRes(suffix + "{" + prefix);
    }


    class TrieNode {
        TrieNode[] children;
        int idx;

        TrieNode() {
            children = new TrieNode[27];
        }


        private void insert(String s, int idx) {
            TrieNode root = this;
            for (char c : s.toCharArray()) {
                int n = c - 'a';
                if (root.children[n] == null) {
                    root.children[n] = new TrieNode();
                }
                root = root.children[n];
                root.idx = idx;
            }
        }

        private int getRes(String s) {
            TrieNode root = this;
            for (char c : s.toCharArray()) {
                if (root.children[c - 'a'] == null)
                    return -1;
                root = root.children[c - 'a'];
            }
            return root.idx;
        }
    }
}
