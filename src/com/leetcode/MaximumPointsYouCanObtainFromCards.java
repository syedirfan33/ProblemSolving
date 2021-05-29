package com.leetcode;

public class MaximumPointsYouCanObtainFromCards {
    // Video from Naresh
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int maxSum = sum;
        int n = cardPoints.length;
        for (int i = k - 1; i >= 0; i--) {
            sum = sum - cardPoints[i] + cardPoints[n + i - k]; // n + k - 1 + k , n + k - 2 + k, so on.
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
