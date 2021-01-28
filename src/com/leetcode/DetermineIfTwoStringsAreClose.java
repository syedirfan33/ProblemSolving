package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DetermineIfTwoStringsAreClose {
    //See another solution below
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

    // Another solution without using priority queue, see another sol below
    public boolean closeStringsII(String word1, String word2) {
        int[] arr1 = new int[26];
        for(char c: word1.toCharArray()){
            arr1[c - 'a']++;
        }
        int[] arr2 = new int[26];
        for(char c: word2.toCharArray()){
            if(arr1[c - 'a'] == 0) return false;
            arr2[c - 'a']++;
        }

        Map<Integer, Integer> m1 = new HashMap<>();
        for(int i: arr1){
            if(i == 0) continue;
            m1.put(i, m1.getOrDefault(i, 0) + 1);
        }

        Map<Integer, Integer> m2 = new HashMap<>();
        for(int i: arr2){
            if(i == 0) continue;
            m2.put(i, m2.getOrDefault(i, 0) + 1);
        }
        if(m1.size() != m2.size()) return false;
        for(int key: m1.keySet()){
            if(!m2.containsKey(key) || m1.get(key) != m2.get(key)) return false;
        }
        return true;
    }

    // We could sort the values, as there will be at most 26 chars in array, so TC is still O(n)
    public boolean closeStringsIII(String word1, String word2) {
        int[] arr1 = new int[26];
        for(char c: word1.toCharArray()){
            arr1[c - 'a']++;
        }
        int[] arr2 = new int[26];
        for(char c: word2.toCharArray()){
            if(arr1[c - 'a'] == 0) return false;
            arr2[c - 'a']++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
