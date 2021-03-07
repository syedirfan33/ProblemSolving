package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    // To solve the follow up, can use hashtable instead of char array
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
