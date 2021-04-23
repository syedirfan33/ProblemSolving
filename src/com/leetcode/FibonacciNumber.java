package com.leetcode;

public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
