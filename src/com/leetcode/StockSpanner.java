package com.leetcode;

import java.util.Stack;

/**
 * @author Syed Irfan - 19/05/2020
 */
public class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] cur = stack.pop();
            res += cur[1]; // or can write res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }
}


