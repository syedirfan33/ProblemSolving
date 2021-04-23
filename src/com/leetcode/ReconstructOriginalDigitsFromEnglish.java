package com.leetcode;

public class ReconstructOriginalDigitsFromEnglish {
    // Video from algorithms made easy
    public String originalDigits(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray())
            counts[c - 'a']++;

        int[] occ = new int[10];
        occ[0] = counts['z' - 'a'];
        occ[2] = counts['w' - 'a'];
        occ[4] = counts['u' - 'a'];
        occ[6] = counts['x' - 'a'];
        occ[8] = counts['g' - 'a'];

        occ[1] = counts['o' - 'a'] - occ[0] - occ[2] - occ[4];
        occ[3] = counts['h' - 'a'] - occ[8];
        occ[5] = counts['f' - 'a'] - occ[4];
        occ[7] = counts['s' - 'a'] - occ[6];
        occ[9] = counts['i' - 'a'] - occ[5] - occ[6] - occ[8];

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            while (occ[i] > 0) {
                res.append(i);
                occ[i]--;
            }
        }
        return res.toString();
    }
}
