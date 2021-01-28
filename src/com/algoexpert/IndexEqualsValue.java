package com.algoexpert;

public class IndexEqualsValue {
    // Same as Citations problem on leetcode
    // I solved it easily, inspired from search for range
    public int indexEqualsValue(int[] array) {
        int res = -1;
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == array[mid]){
                res = mid;
                right = mid - 1;
            }else if(array[mid] > mid){
                right = mid -1 ;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}
