package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifyString {
    public static String underscorifySubstring(String str, String substring) {
        if (str.indexOf(substring) == -1) return str;
        List<int[]> pairs = new ArrayList<>();
        int i = 0;
        int smallLen = substring.length();
        while (i + smallLen <= str.length()) {
            int idx = str.indexOf(substring, i);
            if (idx != -1) {
                pairs.add(new int[]{idx, idx + smallLen});
                i = idx + 1; // we try to find overlapping string too, testestest
            } else {
                break;
            }
        }
        List<int[]> newPairs = collapse(pairs); // This function will convert _test__test into _testest_

        return buildRes(newPairs, str);
    }


    // I tried to collapse without creating a brand new list. i.e by modifying exisiting list
    // For that, I have to remove element from list in case of overlap. But remove method will cost O(N)
    private static List<int[]> collapse(List<int[]> pairs) {

        List<int[]> newPairs = new ArrayList<>();
        int[] cur = pairs.get(0);
        for (int i = 1; i < pairs.size(); i++) {
            if (pairs.get(i)[0] > cur[1]) {
                newPairs.add(cur);
                cur = pairs.get(i);
            } else {
                cur[1] = pairs.get(i)[1];
            }
        }
        newPairs.add(cur);
        return newPairs;
    }

    private static String buildRes(List<int[]> pairs, String str) {
        StringBuilder res = new StringBuilder(str);
        int i = 0;
        for (int[] pair : pairs) {
            res.insert(pair[0] + i, "_");
            i++;
            res.insert(pair[1] + i, "_");
            i++;
        }
        return res.toString();
    }
}
