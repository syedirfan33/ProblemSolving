package com.leetcode;

public class PredictTheWinner {
    int total = 0;
//     public boolean PredictTheWinner(int[] nums) {
//          return dfs(nums, 0, nums.length - 1) >= 0;

//     }

//     private int dfs(int[] nums, int start, int end){
//         if(start >= end) return nums[start];
//         int score1 = nums[start] - dfs(nums, start + 1, end);
//         int score2 = nums[end] - dfs(nums, start, end - 1);
//         System.out.println(score1 + " "+score2);

//         int max = Math.max(score1, score2);
//         return Math.max(score1, score2);
//     }


    // More readable solution : Todo add memoization
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return canWin(nums, 0, n - 1, 0, 0, 1);

    }

    private boolean canWin(int[] nums, int start, int end, int sum1, int sum2, int player) {
        if (start > end) return sum1 >= sum2;
        else if (start == end) {
            if (player == 1) {
                return sum1 + nums[start] >= sum2;
            } else {
                return sum1 < nums[start] + sum2;
            }

        } else {
            if (player == 1) {
                return !canWin(nums, start + 1, end, sum1 + nums[start], sum2, 2) || !canWin(nums, start, end - 1, sum1 + nums[end], sum2, 2);
            } else {
                return !canWin(nums, start + 1, end, sum1, sum2 + nums[start], 1) || !canWin(nums, start, end - 1, sum1, sum2 + nums[end], 1);
            }
        }
    }
}
