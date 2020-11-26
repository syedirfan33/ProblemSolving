package com.leetcode;

import java.util.Stack;

public class MinimumInsertsToBalanceAParanthesisString {
    public int minInsertions(String s) {
        if (s.length() == 0) return 0;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                i++;
            } else if (i < s.length() - 1) {
                if (s.charAt(i + 1) == ')') {
                    if (stack.isEmpty()) res++;
                    else stack.pop();
                    i = i + 2;
                } else {
                    if (stack.isEmpty()) {
                        res += 2;
                    } else {
                        stack.pop();
                        res++;
                    }
                    i++;
                }
            } else {
                if (stack.isEmpty()) {
                    res += 2;
                } else {
                    stack.pop();
                    res++;
                }
                i++;
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
            res += 2;
        }
        return res;
    }


    // same code, using constant space. No need of stack, as we could use a simple counter variable
    public int minInsertionsII(String s) {
        if (s.length() == 0) return 0;
        int count = 0;
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count += 1;
                i++;
            } else if (i < s.length() - 1) {
                if (s.charAt(i + 1) == ')') {
                    if (count == 0) res++;
                    else count -= 1;
                    i = i + 2;
                } else {
                    if (count == 0) {
                        res += 2;
                    } else {
                        count -= 1;
                        res++;
                    }
                    i++;
                }
            } else {
                if (count == 0) {
                    res += 2;
                } else {
                    count -= 1;
                    res++;
                }
                i++;
            }
        }
//        while (count != 0) {
//            count--;
//            res += 2;
//        }
        res += count * 2; // Hahahaha
        return res;
    }
}
