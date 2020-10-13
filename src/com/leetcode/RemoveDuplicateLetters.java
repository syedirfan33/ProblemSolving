package com.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (visited[cur]) continue;
            while (!stack.isEmpty() && stack.peek() > cur && i < lastIdx[stack.peek()]) {
                visited[stack.peek()] = false;
                stack.pop();
            }
            stack.push(cur);
            visited[cur] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append((char) (stack.pop() + 'a'));
        }
        return res.reverse().toString();
    }
}
