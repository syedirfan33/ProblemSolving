package com.leetcode;

public class UniqueSubStringsInWrapAround {
    //https://leetcode.com/problems/unique-substrings-in-wraparound-string/discuss/95439/Concise-Java-solution-using-DP
    public int findSubstringInWraproundString(String p) {
        if (p.length() <= 1) return p.length();
        int[] arr = new int[26];
        int maxCount = 0;
        for (int i = 0; i < p.length(); i++) {
            char cur = p.charAt(i);
            if (i > 0 && (p.charAt(i - 1) + 1 == cur || p.charAt(i - 1) - cur == 25)) // for za
                maxCount++;
            else
                maxCount = 1; // reset

            arr[cur - 'a'] = Math.max(arr[cur - 'a'], maxCount);
        }
        int res = 0;
        for (int num : arr) {
            res += num;
        }
        return res;
    }
}
