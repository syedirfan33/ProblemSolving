package com.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int res = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                res++;
                left++;
                right--;
            } else {
                right--;
                res++;
            }
        }
        return res;
    }
}
