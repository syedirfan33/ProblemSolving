package com.leetcode;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.equals("") || haystack.equals(needle)) return 0;
        int m = haystack.length();
        int n = needle.length();
        int first = 0;
        int second = 0;
        int res = -1;
        while(first < m){
            if(second == n) break;
            if(haystack.charAt(first) == needle.charAt(second)){
                res = res == -1 ? first : res;
                second++;
                first++;
            }else if(second != 0){
                second = 0;
                first = res + 1;
                res = -1;
            }else{
                first++;
            }

        }
        return second != n ? -1 : res;
    }
    //Concise solution
    public int strStrII(String haystack, String needle) {
        if(needle.equals("") || haystack.equals(needle)) return 0;
        for(int i = 0; i + needle.length() <= haystack.length(); i++){
            for(int j = 0; j < needle.length() && haystack.charAt(i+j) == needle.charAt(j); j++){
                if(j == needle.length() -1) return i;
            }
        }
        return -1;
    }
}
