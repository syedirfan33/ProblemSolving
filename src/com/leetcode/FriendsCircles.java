package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FriendsCircles {

     // [1,0,0,1]
     // [0,1,1,0]
     // [0,1,1,1]
     // [1,0,1,1]
    // BFS solution
    public int findCircleNum(int[][] M) {
        int res = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                res++;
                bfs(M, i, visited);
            }
        }
        return res;
    }

    private void bfs(int[][] M, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            visited[cur] = true;
            for (int j = 0; j < M.length; j++) {
                if (visited[j] || M[cur][j] == 0) continue;
                else queue.add(j);
            }
        }
    }

    // DFS using boolean array
    public int findCircleNumII(int[][] M) {
        int res = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                res++;
                dfs(M, i, visited);
            }
        }
        return res;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (visited[j] == false && M[i][j] == 1) {
                dfs(M, j, visited);
            }
        }
    }

    // DFS without using extra array
    public int findCircleNumIII(int[][] M) {
        int res = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(M[i][i] == 1){
                res++;
                dfs(M, i);
            }
        }
        return res;
    }

    private void dfs(int[][] M, int i){
        if(M[i][i] == 0) return;
        M[i][i] = 0;
        for(int j = 0; j < M.length; j++){
            if(M[i][j] == 1){
                dfs(M, j);
            }
        }
    }
}
