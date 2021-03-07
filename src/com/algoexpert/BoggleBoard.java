package com.algoexpert;

import java.util.*;

public class BoggleBoard {
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> res = new HashSet<>();  // Don't ever make res as static in class level, same result is being shared across all test cases hahaha
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, visited, trie.root, res);
            }
        }
        return new ArrayList<>(res);
    }

    private static void dfs(char[][] board, int i, int j, boolean[][] visited, TrieNode node, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;
        char c = board[i][j];
        if (!node.children.containsKey(c)) return;
        node = node.children.get(c);
        if (node.children.containsKey('*')) res.add(node.endWord);
        visited[i][j] = true;
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1], visited, node, res);
        }
        visited[i][j] = false;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String endWord = "";
    }

    static class Trie {
        TrieNode root;
        char endChar;

        Trie() {
            this.root = new TrieNode();
            this.endChar = '*';
        }

        private void add(String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.children.put(endChar, null);
            node.endWord = s;
        }
    }
}
