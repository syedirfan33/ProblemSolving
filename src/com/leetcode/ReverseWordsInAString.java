package com.leetcode;

/**
 * @author Syed Irfan - 16/07/2020
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strArr = s.split(" ");
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!strArr[i].isEmpty()) {
                res.append(strArr[i]);
                res.append(" ");
            }
            
        }
        return res.toString().trim();
    }
}
