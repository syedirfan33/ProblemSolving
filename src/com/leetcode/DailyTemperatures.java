package com.leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T.length <= 1) return T;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < T.length; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int idx = stack.pop();
                int days = i - idx;
                res[idx] = days;
            }
            stack.push(i);
        }
        return res;
    }
}
