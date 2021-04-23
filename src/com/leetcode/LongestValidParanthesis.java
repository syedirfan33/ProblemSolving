package com.leetcode;

import java.util.Stack;

public class LongestValidParanthesis {
    // Video from Prakash Shukla
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexStack.push(i);
                charStack.push('(');
            } else {
                if (charStack.isEmpty())
                    indexStack.push(i);
                else {
                    charStack.pop();
                    indexStack.pop();
                    int lastInvalid = indexStack.isEmpty() ? -1 : indexStack.peek();
                    res = Math.max(res, i - lastInvalid);
                }
            }
        }
        return res;
    }
}
