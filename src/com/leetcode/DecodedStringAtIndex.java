package com.leetcode;

public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        for(char c: S.toCharArray()){
            if(Character.isDigit(c)){
                size *= c - '0';
            }else{
                size++;
            }
        }
        for(int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            K %= size;
            if(K == 0 && Character.isLetter(c)){
                return Character.toString(c);
            }
            if(Character.isDigit(c)){
                size /= c - '0';
            }else{
                size--;
            }
        }
        return "";
    }
}

