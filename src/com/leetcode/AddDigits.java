package com.leetcode;

import java.time.Duration;
import java.time.Instant;

public class AddDigits {
    public static int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;

            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }

        Instant start = Instant.now();
//your code
        for(int i = 0; i < 1000; i++){
            int a = 12;
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        return digitalRoot;
    }

    public static void main(String[] args) {
        addDigits(10);
    }
}
