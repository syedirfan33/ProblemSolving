package com.leetcode;

public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                res = repeat(c, res);
            } else {
                res.append(c);
            }

            if (res.length() <= K) return res.charAt(K - 1) + "";
        }
        return "";
    }
}

