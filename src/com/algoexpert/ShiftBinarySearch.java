package com.algoexpert;

public class ShiftBinarySearch {
    // Samw as search in a rotated sorted array
    public static int shiftedBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right -  left) / 2;
            if(array[mid] == target)
                return mid;
                // this means left part is sorted as expected
                // 45, 61, 71, 72, 73, 0, 1, 21, 33, 37
            else if(array[left] <= array[mid]){  // consider [3,1] ->1
                if(target >= array[left] && target < array[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1; // explore right part
                }
                // 61, 71, 72, 73, 0, 1, 21, 33, 37, 45
            }else{
                if(target > array[mid] && target <= array[right]){
                    left = mid + 1; // should be in right part
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
