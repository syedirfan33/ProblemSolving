package com.leetcode;

public class PrimeOrNot {
    public static void main(String args[]) {
        System.out.println(isPrime(7));
        System.out.println(isPrime(25));
    }

    private static int isPrime(int input) {
        int res = 1;
        boolean isPrime = true;
        for (int i = 2; i <= input / 2; i++) {
            if (input % i == 0) {
                isPrime = false;
                res = i;
                break;
            }
        }
        if (isPrime) {
            return 1;
        }
        return res;
    }
}
