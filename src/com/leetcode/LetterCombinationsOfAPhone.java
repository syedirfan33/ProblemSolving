package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhone {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        String[] arr = {"-", "-",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        dfs(digits, arr, new StringBuilder(), 0);
        return res;
    }

    private void dfs(String digits, String[] arr, StringBuilder cur, int idx) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }
        String alpStr = arr[digits.charAt(idx) - '0'];
        for (int i = 0; i < alpStr.length(); i++) {
            cur.append(alpStr.charAt(i));
            dfs(digits, arr, cur, idx + 1);
            cur.deleteCharAt(cur.length() - 1);

            // Or we can use below if u need to avoid moving behaviour. Note that, below doesn't work with
            //StringBuilder. We have to use String.
            //dfs(digits, arr, cur + alpStr.charAt(i), idx + 1);
        }
    }
}
