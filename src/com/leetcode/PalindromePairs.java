package com.leetcode;

import java.util.*;

public class PalindromePairs {
    //got TLE - O(n2 * k ) where K is the length of longest word
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j && isPalindrome(i, j, words)){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(int i, int j, String[] words){
        String s = words[i] + words[j];
        if(s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    // TC - O(n * k2)
    public List<List<Integer>> palindromePairsII(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        if(map.containsKey("")){
            int idx = map.get("");
            for(int i = 0; i < words.length; i++){
                if(i != idx && isPalindrome(words[i])){
                    res.add(Arrays.asList(i, idx));
                    res.add(Arrays.asList(idx, i));
                }
            }
        }

        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            String other = new StringBuilder(cur).reverse().toString();
            Integer idx = map.get(other);
            if(idx != null && i != idx){
                res.add(Arrays.asList(i, map.get(other)));
            }
        }

        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            for(int cut = 1; cut < cur.length(); cut++){
                String left = cur.substring(0, cut);
                String right = cur.substring(cut);

                if(isPalindrome(left)){
                    String other = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(other)){
                        res.add(Arrays.asList(map.get(other), i));
                    }
                }

                if(isPalindrome(right)){
                    String other = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(other)){
                        res.add(Arrays.asList(i, map.get(other)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

}
