package com.leetcode;

/**
 * @author Syed Irfan - 05/07/2020
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int res = 0;
        int i = s1.length() - 1;
        int k = s2.length() - 1;
        while (i >= 0 && k >= 0) {
            res += s1.charAt(i) == s2.charAt(k) ? 0 : 1;
            i--;
            k--;
        }
        if (s1.length() == s2.length()) return res;
        String leftOver = s1.length() > s2.length() ? s1 : s2;
        for (int j = 0; j < Math.abs(s1.length() - s2.length()); j++) {
            res += leftOver.charAt(j) == '1' ? 1 : 0;
            
        }
        return res;
    }
    
    // Solution II using xor operation.
  /*  public int hammingDistance(int x, int y) {
        int result = 0;
        while(x > 0 || y > 0){
            result += (x % 2) ^ (y % 2);
            x /= 2;
            y /= 2;
        }
        return result;
    }*/
}
