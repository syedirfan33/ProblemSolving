package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 04/06/2020
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] data = new int[26];
        for (int i = 'a'; i <= 'z'; i++) {
            int idx = -1;
            for (int j = 0; j < rows.length; j++) {
                if (rows[j].indexOf(i) >= 0) {
                    idx = j;
                    break;
                }
            }
            data[i - 'a'] = idx;
            
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean isSame = true;
            String lowWord = word.toLowerCase();
            if (word.length() > 0) {
                int curIdx = data[lowWord.charAt(0) - 'a'];
                for (char c : lowWord.toCharArray()) {
                    if (data[c - 'a'] != curIdx) {
                        isSame = false;
                        break;
                    }
                }
            }
            if (isSame) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}
