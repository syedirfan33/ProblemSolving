package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordPattern {

    //Can use hashmap too
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length()) return false;
            Set<String> found = new HashSet<>();
            String[] arr = new String[26];
            for (int i = 0; i < pattern.length(); i++) {
                int idx = pattern.charAt(i) - 'a';
                if (arr[idx] == null) {
                    if (found.contains(words[i])) return false;
                    arr[idx] = words[i];
                    found.add(words[i]);
                } else {
                    if (!arr[idx].equals(words[i])) return false;
                }
            }
            return true;
        }
    }
}
