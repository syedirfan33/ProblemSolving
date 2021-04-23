package com.leetcode;

public class CodilityReformatPhoneNumber {
    public String solution(String S) {
        StringBuilder res = new StringBuilder();
        int len = 0;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                res.append(c);
                len++;

                if (len % 3 == 0)
                    res.append('-');
            }
        }
        if (res.length() <= 3 || len % 3 == 2) {
            return res.toString();
        }
        // Handling i % 3 == 0
        if (res.charAt(res.length() - 1) == '-') {
            res.deleteCharAt(res.length() - 1);
            // Handling i % 3 == 1
        } else if (res.charAt(res.length() - 2) == '-') {
            res.deleteCharAt(res.length() - 2);
            res.insert(res.length() - 2, '-');
        }
        return res.toString();
    }

    private String appendDash(StringBuilder str) {
        int i = 0;
        int j = 0;
        int len = str.length();
        while (i < len) {
            if (i % 3 == 0) {
                str.insert(i, '-');
            }
        }
        return str.toString();
    }
}
