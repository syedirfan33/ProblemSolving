package com.algoexpert;

/**
 * @author Syed Irfan - 25/05/2020
 */
public class LongestPeak {
    public static void main(String[] args) {
        int inp = longestPeak(new int[]{1,2,3,3,4,0,10,6,5, -1, -3, 2, 3});
        System.out.println("inp = " + inp);
    }
    public static int longestPeak(int[] arr) {
        int peak = 0;
        int i = 1;
        int arrLen = arr.length;
        while(i < arrLen - 1){
            boolean isPeak = arr[i] > arr[i - 1] && arr[i] > arr[i + 1];
            if(!isPeak){
                i++;
                continue;
            }
            int leftIdx = i - 1;
            int rightIdx = i + 1;
            while(leftIdx > 0 && arr[leftIdx] > arr[leftIdx - 1]){
                leftIdx--;
            }
            while(rightIdx < arrLen - 1 && arr[rightIdx] > arr[rightIdx + 1]){
                rightIdx++;
            }
            System.out.println(i+"leftIdx = " + leftIdx + " rightIdx = " + rightIdx);
            int cur = rightIdx - leftIdx + 1;
            peak = Math.max(cur,peak);
            i = rightIdx;
        }
        
        return peak;
    }
}
