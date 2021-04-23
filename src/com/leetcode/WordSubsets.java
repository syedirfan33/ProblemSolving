package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {

    // My solution, got TLE, O(AB), can be improved to O(A + B) see below.
    public List<String> wordSubsets(String[] A, String[] B) {
        Map<String, Map<Character, Integer>> map = new HashMap<>();

        for(String b: B){
            Map<Character, Integer> cur = new HashMap<>();
            for(char c: b.toCharArray()){
                cur.put(c, cur.getOrDefault(c, 0) + 1);
            }
            map.put(b, cur);
        }

        List<String> res = new ArrayList<>();
        for(String a: A){
            Map<Character, Integer> aCur = new HashMap<>();
            for(char c: a.toCharArray()){
                aCur.put(c, aCur.getOrDefault(c, 0) + 1);
            }
            boolean isValid = true;
            for(String other: B){
                if(!valid(map, other, aCur)){
                    isValid = false;
                    break;
                }
            }
            if(isValid) res.add(a);
        }
        return res;
    }

    private boolean valid(Map<String, Map<Character, Integer>> map, String b, Map<Character, Integer> cur){
        Map<Character, Integer> bMap = map.get(b);
        for(char c: bMap.keySet()){
            if(!cur.containsKey(c) || bMap.get(c) > cur.get(c)) return false;
        }
        return true;
    }

    public List<String> wordSubsetsII(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] bMax = new int[26];
        for(String b: B){
            int[] cur = count(b);
            for(int i = 0; i < 26; i++){
                bMax[i] = Math.max(bMax[i], cur[i]);
            }
        }

        for(String a: A){
            int[] cur = count(a);
            int i;
            for(i = 0; i < 26; i++){
                if(cur[i] < bMax[i]) break;
            }
            if(i == 26) res.add(a);
        }
        return res;
    }

    private int[] count(String str){
        int[] res = new int[26];
        for(char c: str.toCharArray()){
            res[c - 'a']++;
        }
        return res;
    }
}
