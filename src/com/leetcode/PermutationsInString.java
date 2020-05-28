package com.leetcode;

/**
 * @author Syed Irfan - 18/05/2020
 * Same as AllAnagrams
 */
public class PermutationsInString {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m > n) return false;
        int[] mArr = new int[26];
        int[] nArr = new int[26];
        for(int i=0;i<m;i++){
            mArr[s1.charAt(i) - 'a']++;
            nArr[s2.charAt(i) - 'a']++;
        }
        int i = m;
        while(i<n){
            if(isSame(mArr, nArr)) return true;
            nArr[s2.charAt(i-m) - 'a']--;
            nArr[s2.charAt(i) - 'a']++;
            i++;

        }
        return isSame(mArr, nArr);
    }

    private boolean isSame(int[] a1, int[] a2){
        for(int i=0;i<26;i++){
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }
}
