package com.leetcode;

/**
 * @author Syed Irfan - 20/05/2020
 */
public class PrintPrimeFactors {
    public static final int total_numbers = 1500;
    public static void main(String[] args) {
        printFactors();
    }
    private static void printFactors(){
        int[] divisors = {2,3,5};
        int count = 1;
        int num = 2;
        while(count <= total_numbers){
            int cur = num;
            for (int divisor: divisors) {
                while(cur%divisor == 0){
                    cur /= divisor;
                }
            }
            if (cur == 1) {
                count++;
            }
            num++;
        }
    }
}
