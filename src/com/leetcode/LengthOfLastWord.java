package com.leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            max = i - j;

            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            j = i;
        }
        return max;
    }


    //Optimised solution
    public int lengthOfLastWord2(String s) {

        s = s.trim();
        int i = s.length() - 1;
        while (i > 0 && s.charAt(i) != ' ') {
            i--;
        }
        if (i == 0) return s.length() - i;
        return s.length() - i - 1;
    }
}
