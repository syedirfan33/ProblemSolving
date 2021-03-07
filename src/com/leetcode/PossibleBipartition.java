package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 27/05/2020
 */
public class PossibleBipartition {
    public static void main(String[] args) {
        int[][] inp = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(4, inp));
    }
    
    // It is a typical graph search problem based on Bipartite graph (coloring technique), same solution as is graph bipartite. Just that we nee to create a adj list
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] arr = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            arr[dislike[0]].add(dislike[1]);
            arr[dislike[1]].add(dislike[0]);
        }
        
        int[] colors = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if (colors[i] == 0) { // [[1,2],[1,3],[2,4]]
                colors[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    for (int neighbour : arr[cur]) {
                        if (colors[neighbour] == colors[cur]) {
                            return false;
                        }
                        if (colors[neighbour] == 0) {
                            colors[neighbour] = -colors[cur];
                            queue.add(neighbour);
                        }
                    }
                }
            }
            
        }
        return true;
    }
}