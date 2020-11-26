package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
