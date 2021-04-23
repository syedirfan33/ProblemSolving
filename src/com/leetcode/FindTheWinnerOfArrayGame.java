package com.leetcode;

import java.util.LinkedList;

public class FindTheWinnerOfArrayGame {
    public int getWinner(int[] arr, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int num : arr) q.add(num);

        k = Math.min(k, arr.length);
        int num = k;
        while (true) {
            if (num == 0) return q.peekFirst();
            int num1 = q.remove();
            while (q.peek() < num1) {
                int n = q.remove();
                q.addLast(n);
                num--;
                if (num == 0) return num1;
            }
            num = k - 1;
            q.addLast(num1);
        }
    }

    //Don't need a queue or push the elements.

    //If you don't find the winner after one pass,
    //the winner will be max(A),
    //bacause no one will beats him anymore.
    public int getWinnerII(int[] arr, int k) {
        int winner = arr[0];
        int wins = 0;
        for (int i = 1; i < arr.length; i++) {
            if (winner > arr[i]) {
                wins++;
            } else {
                wins = 1;
                winner = arr[i];
            }

            if (wins == k) break;
        }
        return winner;
    }
}
