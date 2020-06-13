package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 03/06/2020
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[b4[F]c]"));
    }
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> data = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                StringBuilder dig = new StringBuilder();
                dig.append(cur);
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    dig.append(s.charAt(i));
                    i++;
                }
                i--;
                counts.push(Integer.parseInt(dig.toString()));
            } else if (cur == '[') {
                data.push(res);
                res = new StringBuilder();
            } else if (cur == ']') {
                int curCount = counts.pop();
                StringBuilder temp = data.pop();
                for (int j = 0; j < curCount; j++) {
                    temp.append(res);
                }
                res = temp;
            } else {
                res.append(cur);
            }
        }
        return res.toString();
    }
    
}
