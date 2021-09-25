package com.leetcode;

public class FirstMissingPositive {

    // 4 3 2 1
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int posi = nums[i] - 1;
            while (nums[i] >= 1 && nums[i] <= n && nums[posi] != posi + 1) {
                swap(nums, posi, i);
                posi = nums[i] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int posi, int i) {
        int temp = nums[posi];
        nums[posi] = posi + 1;
        nums[i] = temp;
    }


    //Another clear solution

   /* public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < nums.length) {
            if( (nums[i] > 0) && (nums[i] <= n) && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]);
            }
            else
                i++;
        }
        for( int j = 0; j<nums.length; j++) {
            if( nums[j] != j+1)
                return j+1;
        }
        return n+1;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b-1];
        nums[b-1] = temp;
    }*/
}
