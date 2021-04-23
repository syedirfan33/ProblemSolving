package com.leetcode;

import java.util.List;

public class ReplaceWords {
    //Solved myself.
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        for (String word : dictionary) {
            construct(word);
        }
        String[] words = sentence.split("\\s");
        for (String word : words) {
            res.append(find(word));
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private String find(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.endWord.equals("")) return node.endWord;

            if (node.children[c - 'a'] == null) return word;
            node = node.children[c - 'a'];
        }
        return word;
    }

    private void construct(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.endWord = word;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String endWord = "";
    }
}
