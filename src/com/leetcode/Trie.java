package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    /**
     * Initialize your data structure here. - This is prefix trie
     */
    Map<Character, Trie> children;  // Note that for children, we could also use Trie[26] instead of map to make it bit efficient.

    public Trie() {
        children = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c))
                node.children.put(c, new Trie());

            node = node.children.get(c);
        }
        node.children.put('#', null);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return node.children.containsKey('#');
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
