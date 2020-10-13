package com.leetcode;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] arr = new int[26];
            for (int i = 0; i < A.length(); i++) {
                arr[A.charAt(i) - 'a']++;
            }
            for (int num : arr) {
                if (num > 1) return true;
            }
            return false;
        } else {
            int diff1 = -1;
            int diff2 = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (diff1 == -1) diff1 = i;
                    else if (diff2 == -1) diff2 = i;
                    else return false;
                }
            }
            return diff2 != -1 && A.charAt(diff1) == B.charAt(diff2) && A.charAt(diff2) == B.charAt(diff1);
        }

    }
}
