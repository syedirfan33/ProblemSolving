package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String str : path.split("/")){
            if(str.equals("") || str.equals(".")) continue;
            else if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop(); // Can use poll() method of deque which won't throw ESE
            }
            else stack.push(str);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop()).insert(0,"/"); // Can use deque to remove last element first
        }
        return res.toString();
    }


    //SLIGHTLY FAST SOLUTION
    public String simplifyPathII(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
