package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 07/06/2020
 */
public class BrowserHistory {
    String[] stack;
    int index = 0;
    int top = 0;
    
    public BrowserHistory(String homepage) {
        stack = new String[101];
        stack[index] = homepage;
        int[] arr = {1, 3};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2, (a, b) -> b - a);
    }
    
    public void visit(String url) {
        index++;
        stack[index] = url;
        for(int i = index + 1; i < 101  ; i++){
            stack[i] = null;
        }
        top = index;
        
    }
    
    public String back(int steps) {
        if (index - steps >=0) {
            index = index - steps;
        }else{
            index = 0;
        }
        return stack[index];
    }
    
    public String forward(int steps) {
        if ( index + steps <= top) {
            index = index + steps;
        }else{
            index = top;
        }
        return stack[index];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */