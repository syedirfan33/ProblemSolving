package com.leetcode;

import java.util.Stack;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return j == n;
    }
}
