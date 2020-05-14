package com.leetcode;

/**
 * @author Syed Irfan - 14/05/2020
 */
public class RemoveKdigits {
    public String remove(String num, int k){
        StringBuilder res = new StringBuilder(num);
        int i = 0;
        while (k>0) {
            while (i<res.length()-1 && res.charAt(i) <= res.charAt(i+1)) {
                i++;
            }
            res.deleteCharAt(i);
            k--;
        }
        int j = 0;
        while (res.length()>0 && res.charAt(j) == '0') {
            res.deleteCharAt(j);
        }
        return res.length() > 0 ? res.toString() : "0";
    }


}
