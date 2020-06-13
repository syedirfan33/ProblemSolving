package com.leetcode;

import java.util.*;
import java.util.stream.*;

/**
 * @author Syed Irfan - 07/06/2020
 */
public class GetStrongest {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length - 1;
        int median = (len) / 2;
        System.out.println(median + "" + arr[median]);
        int num = arr[median];
        int[] arr3 = IntStream.of(arr).boxed().sorted((a, b) -> Math.abs(a - num) == Math.abs(b - num) ? b - a : Math.abs( b - num ) - Math.abs(a - num) ).mapToInt(Integer::intValue).toArray();
        
        int[] arr4 = new int[k];
        for(int i = 0; i < k; i++){
            arr4[i] = arr3[i];
        }
        return arr;
    }
}
