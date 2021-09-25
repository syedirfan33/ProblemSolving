package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    // took little help to comment section, excellent solution
    Set<String> res;
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        root = new TrieNode();
        m = board.length;
        n = board[0].length;
        for (String word : words) {
            buildTrie(word, root);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null)
                    dfs(root, board, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(TrieNode node, char[][] board, int i, int j) {
        if (!isValid(i, j) || board[i][j] == '#')
            return;
        char c = board[i][j];
        if (node.children[c - 'a'] == null)
            return;
        node = node.children[c - 'a'];
        if (node.endWord != null)
            res.add(node.endWord);

        board[i][j] = '#';
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(node, board, nextI, nextJ);
        }
        board[i][j] = c;
    }


    private boolean isValid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }


    private void buildTrie(String word, TrieNode root) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.endWord = word;
    }


    public class TrieNode {
        TrieNode[] children;
        String endWord;

        TrieNode() {
            children = new TrieNode[26];
            endWord = null;
        }

    }
    //Solved myself, but not so optimised
    /*List<String> res;
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        for(String word: words){
            boolean added = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(word.charAt(0) == board[i][j] && dfs(word, board, i, j, 0, new boolean[m][n])){
                        res.add(word);
                        added = true;
                        break;
                    }
                }
                if(added) break;
            }

        }
        return res;
    }

    private boolean dfs(String word, char[][] board, int i, int j, int idx, boolean[][] visited){
        if(visited[i][j] == true || board[i][j] != word.charAt(idx))
            return false;
        idx++;
        if(idx == word.length())
            return true;
        boolean res = false;
        visited[i][j] = true;
        for(int[] dir: dirs){
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if(isValid(nextI, nextJ) && visited[nextI][nextJ] == false){
                res = res || dfs(word, board, nextI, nextJ, idx, visited);
            }
        }
        if(!res)
            visited[i][j] = false;
        return res;
    }

    private boolean isValid(int i, int j){
        return i >= 0 && i < m && j >= 0 && j < n;
    }*/
}
