package com.leetcode;

/**
 * @author Syed Irfan - 09/06/2020
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int first = 0;
        int second = 0;
        while(first < s.length() && second < t.length()){
            if(s.charAt(first) == t.charAt(second)){
                first++;
            }
            second++;
        }
        return first == s.length();
    }
}
