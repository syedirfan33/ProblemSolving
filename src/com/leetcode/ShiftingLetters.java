package com.leetcode;

public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        shifts[shifts.length - 1] %= 26;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char newChar = (char) (((S.charAt(i) - 'a' + shifts[i]) % 26) + 'a');
            res.append(newChar);
        }
        return res.toString();
    }
}
