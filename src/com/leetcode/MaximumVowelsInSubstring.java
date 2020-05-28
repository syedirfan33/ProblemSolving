package com.leetcode;

/**
 * @author Syed Irfan - 25/05/2020
 */
public class MaximumVowelsInSubstring {
    public static void main(String[] args) {
        System.out.println(maxVowels("", 0));
    }
    
    public static int maxVowels(String s, int k) {
        int n = s.length();
        int total = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                total++;
        }
        int res = total;
        int left = 0;
        while (left + k < n) {
            int right = left + k;
            if (isVowel(s.charAt(left))) total--;
            left++;
            if (isVowel(s.charAt(right))) total++;
            res = Math.max(res, total);
        }
        return res;
    }
    
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
}
