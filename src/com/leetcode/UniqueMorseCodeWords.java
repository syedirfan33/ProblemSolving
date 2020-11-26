package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (String word : words) {
            StringBuilder cur = new StringBuilder();
            for (char c : word.toCharArray()) {
                cur.append(morse[c - 'a']);
            }
            set.add(cur.toString());
        }
        return set.size();
    }
}
