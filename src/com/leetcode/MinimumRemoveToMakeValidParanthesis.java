package com.leetcode;

import java.util.Stack;

/**
 * @author Syed Irfan - 15/06/2020
 */
public class MinimumRemoveToMakeValidParanthesis {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') stack.push(i);
            else if (arr[i] == ')') {
                if (!stack.isEmpty()) stack.pop();
                else arr[i] = '-'; // We found invalid character
            }
        }
        while (!stack.isEmpty()) arr[stack.pop()] = '-';
        s = new String(arr).replaceAll("-", "");
        return s;
    }
}

