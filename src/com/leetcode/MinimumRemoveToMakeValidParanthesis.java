package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Syed Irfan - 15/06/2020
 */
public class MinimumRemoveToMakeValidParanthesis {
    public String minRemoveToMakeValid(String s) {
        char[] res = s.toCharArray();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                queue.add(i);
                
            } else if (s.charAt(i) == ')') {
                if (queue.isEmpty()) {
                    res[i] = '0';
                } else {
                    queue.remove();
                }
            }

        }
        while (!queue.isEmpty()) {
            int idx = queue.remove();
            res[idx] = '0';
        }
        
        return new String(res).replaceAll("0", "");
    }
}

