package com.leetcode;

/**
 * @author Syed Irfan - 03/06/2020
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                nums[secret.charAt(i) - '0']++;
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            char curGuess = guess.charAt(i);
            if (secret.charAt(i) != curGuess && nums[curGuess - '0'] > 0) {
                cows++;
                nums[curGuess - '0']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
        // return new String(bulls+"A"+cows+"B"); this had 90%
    }
    
}
