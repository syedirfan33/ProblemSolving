package com.leetcode;

import java.util.*;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Integer> template = new HashMap<>();
        int i = 0;
        for (char c : pattern.toCharArray()) {
            if (!template.containsKey(c)) {
                template.put(c, i);
                i++;
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) continue;
            Map<Character, Integer> map = new HashMap<>();
            int j = 0;
            int other = 0;
            boolean canAdd = true;
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, j);
                    j++;
                }

                if (map.get(c) != template.get(pattern.charAt(other))) {
                    canAdd = false;
                    break;
                }
                other++;
            }
            if (canAdd) res.add(word);
        }
        return res;
    }

    // Easy solution, coding decoded.
    public List<String> findAndReplacePatternII(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        String normalised = normalize(pattern);

        for (String word : words) {
            if (word.length() == pattern.length() && normalised.equals(normalize(word)))
                res.add(word);
        }
        Map<String, List<String>> map = new HashMap<>();
        return res;
    }

    private String normalize(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, map.size());
            }
            res.append(map.get(c));
        }
        return res.toString();
    }
}
