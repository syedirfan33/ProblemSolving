package com.leetcode;

public class LongestSubstringWithAtleastKRepeatingChars {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (k <= 1) return len;
        if (len == 0 || len < k) return 0;

        int[] freq = new int[26];
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            freq[c - 'a']++;
        }
        int i = 0;
        while (i < len && freq[sArr[i] - 'a'] >= k) i++;

        if (i >= len - 1) return i; // see eg, aaabbc and aaabb

        int leftRes = longestSubstring(s.substring(0, i), k);
        while (i < len && freq[sArr[i] - 'a'] < k) i++; // this is just an optimization.
        int rightRes = i < len ? longestSubstring(s.substring(i), k) : 0;

        return Math.max(leftRes, rightRes);
    }
}
