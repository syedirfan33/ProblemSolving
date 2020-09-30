package com.leetcode;

public class ExcelTitleToNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int mul = s.length() - 1 - i;
            double val = Math.pow(26, mul) * (s.charAt(i) - 'A' + 1);
            res += val;
        }
        return res;
    }
}

//Simple version
//public int titleToNumber(String s) {
//    int res = 0;
//    for (char c: s.toCharArray()) {
//        res *= 26;
//        res += (c-'A'+1);
//    }
//    return res;
//}