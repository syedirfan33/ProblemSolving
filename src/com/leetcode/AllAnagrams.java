package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Irfan - 17/05/2020
 */
public class AllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();



        int pLen = p.length();
        int sLen = s.length();

        if (s == null || s.length() == 0 || pLen > sLen ) {
            return res;
        }

        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for(int i=0; i<pLen;i++){
            pArr[p.charAt(i) - 'a']++;
            sArr[s.charAt(i) - 'a']++;
        }
        int i = pLen;
        while(i < sLen){
            if(isAnagram(pArr, sArr)){
                res.add(i - pLen);
            }
            sArr[s.charAt(i-pLen) - 'a']--;
            sArr[s.charAt(i) - 'a']++;
            i++;

        }
        if(isAnagram(pArr, sArr)){
            res.add(i - pLen);
        }
        return res;
    }

    private boolean isAnagram(int[] s, int[] p) {
        for(int i=0;i<26;i++){
            if(s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }


}
