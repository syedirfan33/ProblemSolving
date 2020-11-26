package com.leetcode;

import java.util.Stack;

public class BasicCaluculatorII {
    public int calculate(String s) {
        int prevSign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                int digit = cur - '0';
                num = num * 10 + digit;
            }
            if (!Character.isDigit(cur) && cur != ' ' || i == s.length() - 1) { // This is imp
                                                                                // See test case
                                                                                // "0-2147483647"
                switch (prevSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                prevSign = cur;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
