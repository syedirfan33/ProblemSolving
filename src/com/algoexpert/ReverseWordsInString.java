package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWordsInString(String string) {
        if (string.length() <= 1) return string;
        List<StringBuilder> strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                strList.add(sb);
                sb = new StringBuilder();
            } else {
                sb.append(string.charAt(i));
            }
        }
        strList.add(sb); // for last iteration
        StringBuilder res = new StringBuilder();
        for (int i = strList.size() - 1; i >= 0; i--) {
            res.append(strList.get(i));
            if (i != 0) res.append(" ");
        }
        return res.toString();
    }
}
