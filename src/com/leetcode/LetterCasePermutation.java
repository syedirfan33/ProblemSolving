package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        helper(S.toCharArray(), 0);
        return res;
    }

    private void helper(char[] S, int index) {
        if (index >= S.length) {
            res.add(new String(S));
            return;
        }
        char c = S[index];
        if (Character.isLetter(c)) {
            S[index] = Character.toUpperCase(c); // Call dfs for lower case once, and uppercase once.
            helper(S, index + 1);
            S[index] = Character.toLowerCase(c); // BackTracking.
            helper(S, index + 1);
        } else {
            helper(S, index + 1);
        }
    }
}
