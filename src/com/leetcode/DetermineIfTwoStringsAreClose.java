package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        Map<Character, Integer> m1 = new HashMap<>();
        for(char c: word1.toCharArray()){
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> m2 = new HashMap<>();
        for(char c: word2.toCharArray()){
            if(!m1.containsKey(c)) return false;
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }
        q1.addAll(m1.values());
        q2.addAll(m2.values());
        while(!q1.isEmpty() && !q2.isEmpty()){
            int one = q1.remove();
            int two = q2.remove();
            if(one != two) {   // Don't use "if(q1.remove() != q2.remove())" to compare, it doesn't work for some reasons
                return false;
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
