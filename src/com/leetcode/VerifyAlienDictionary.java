/**
 *
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class VerifyAlienDictionary {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }


    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabets = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabets[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length())
                    return false; // consider [applepen, apple]
                int firstPosi = alphabets[words[i].charAt(j) - 'a'];
                int secondPosi = alphabets[words[i + 1].charAt(j) - 'a'];
                if (firstPosi < secondPosi)
                    break;
                else if (firstPosi > secondPosi)
                    return false;
            }
        }
        return true;
    }

}
