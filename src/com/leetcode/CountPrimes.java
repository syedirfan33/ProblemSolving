package com.leetcode;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    //Slightly Improved solution
    public int countPrimesII(int n) {
        if(n <= 1) return 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i * i < n; i++){
            if(notPrime[i] == false){
                for(int j = 2; i * j < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false) count++;
        }
        return count;
    }
}
