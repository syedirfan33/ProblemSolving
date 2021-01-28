package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    // While most of the solutions out there claim that O(n), I think it's o(n2), so I deduced another solution
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int i = 0;
        int j = 0;
        int max = 0;
        int[] arr = new int[128];
        while (j < s.length()) {
            if (arr[s.charAt(j) - ' '] == 0) {
                arr[s.charAt(j) - ' ']++;
                j++;
                max = Math.max(max, j - i);
            } else {
                arr[s.charAt(i) - ' ']--;
                i++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringII(String str) {
        if (str.length() <= 1) return str.length();
        Map<Character, Integer> map = new HashMap<>();
        int longestLen = 0;
        int startIdx = 0;
        int resIdx = 0; // Algo expert asked to return string as output. So it is used.
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c) && map.get(c) >= startIdx) { // char comes after start idx
                if (i - startIdx > longestLen) {
                    longestLen = i - startIdx;
                    resIdx = startIdx;
                }
                startIdx = map.get(c) + 1;
            }
            map.put(c, i);
        }
        if (i - startIdx > longestLen) return i - startIdx; // Algo expert - return return str.substring(startIdx);
        return longestLen;                                 //Algo expert - return str.substring(resIdx, resIdx + longestLen);
    }
}
