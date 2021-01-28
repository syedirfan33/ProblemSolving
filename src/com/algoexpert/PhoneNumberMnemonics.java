package com.algoexpert;

import java.util.ArrayList;


// Same as letter combinations of a phone leetcode
public class PhoneNumberMnemonics {


    ArrayList<String> res;

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        res = new ArrayList<>();
        String[] mnemonics = new String[]{
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
                "0"
        };
        dfs(phoneNumber, 0, mnemonics, new StringBuilder());
        return res;
    }

    private void dfs(String number, int idx, String[] mnemonics, StringBuilder cur) {
        if (idx == number.length()) {
            res.add(cur.toString());
            return;
        }
        String c = mnemonics[number.charAt(idx) - '0'];
        for (int i = 0; i < c.length(); i++) {
            cur.append(c.charAt(i));
            dfs(number, idx + 1, mnemonics, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
