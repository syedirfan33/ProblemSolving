package com.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.

    // ---This is very easy, just focus and think !!!
    // TC O(n2), SC O(n2)
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                construct(str, i);
            }
        }

        private void construct(String str, int index) {
            TrieNode node = root;
            for (int i = index; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!node.children.containsKey(c))
                    node.children.put(c, new TrieNode());

                node = node.children.get(c);
            }
            node.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
