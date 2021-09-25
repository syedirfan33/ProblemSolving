package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int[] master = fillChars(p);
        int[] other = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            other[c - 'a']++;
            if (i >= pLen - 1) {
                if (valid(master, other)) {
                    res.add(i - pLen + 1);
                }
                other[s.charAt(i - pLen + 1) - 'a']--;
            }
        }
        return res;
    }

    private int[] fillChars(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray())
            res[c - 'a']++;
        return res;
    }

    private boolean valid(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }
}
